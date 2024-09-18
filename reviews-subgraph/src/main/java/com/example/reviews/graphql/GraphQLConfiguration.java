package com.example.reviews.graphql;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.apollographql.federation.graphqljava.Federation;
import com.apollographql.federation.graphqljava._Entity;
import com.example.reviews.model.Product;
import graphql.schema.DataFetcher;

import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.ClassNameTypeResolver;
import static com.example.reviews.model.Product.PRODUCT_TYPE;

@Configuration
public class GraphQLConfiguration {

  @Bean
  public GraphQlSourceBuilderCustomizer federationTransform() {
    DataFetcher<?> entityDataFetcher = env -> {
      List<Map<String, Object>> representations = env.getArgument(_Entity.argumentName);
      List<Product> products = representations.stream()
        .map(representationsToStub())
        .collect(getList());
      System.out.println(products);
      return products;
    };

    return builder -> builder.schemaFactory((registry, wiring) -> buildGraphQLSource(entityDataFetcher, registry, wiring));
  }

  @NotNull
  private static Collector<Product, ?, List<Product>> getList() {
    return Collectors.toList();
  }

  private static GraphQLSchema buildGraphQLSource(DataFetcher<?> entityDataFetcher, TypeDefinitionRegistry registry, RuntimeWiring wiring) {
    return Federation.transform(registry, wiring)
      .fetchEntities(entityDataFetcher)
      .resolveEntityType(typeResolver())
      .build();
  }

  private static ClassNameTypeResolver typeResolver() {
    return new ClassNameTypeResolver();
  }

  /**
   In
       representation = {LinkedHashMap@9921}  size = 2
       "id" -> "2"
       "__typename" -> "Product"
   Out
       productStub = {Product@9923} "Product[id=2]"
       id = "2"
   */
  @NotNull
  private static Function<Map<String, Object>, Product> representationsToStub() {
    Function<Map<String, Object>, Product> representations = representation -> {
      if (PRODUCT_TYPE.equals(representation.get("__typename"))) {
        Product productStub = new Product((String) representation.get("id"));
        return productStub;
      }
      return null;
    };

    return representations;
  }
}
