package com.example.products.graphql;

import com.apollographql.federation.graphqljava.Federation;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductsGraphQLConfiguration {

  @Bean
  public GraphQlSourceBuilderCustomizer productFederationTransform() {
    return builder -> {
      builder.schemaFactory((registry, wiring) ->
        Federation.transform(registry, wiring)
          .fetchEntities(env -> null)
          .resolveEntityType(env -> null)
          .build()
      );
    };
  }
}
