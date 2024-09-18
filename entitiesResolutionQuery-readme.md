# entitiesResolutionQuerySendingRepresentations

```graphql
query entityResolutionQuery{

    _entities(representations: [
        { __typename: "Product", id: "1" },
        { __typename: "Product", id: "2" },
        { __typename: "Product", id: "3" }
    ]) {
        __typename
        ... on Product {
            id
            __typename
            reviews{
                id
            }
        }
    }

}
```

# Representations sent and entityStubs Returned
```

# ##########################
# representation =  size = 2
#  "id" -> "6"
#  "__typename" -> "Product"
# productStub = "Product[id=6]"
#  id = "6"
# ##########################
# representations =  size = 6
#  0 =  size = 2
#   "id" -> "1"
#   "__typename" -> "Product"
#  1 =  size = 2
#  2 =  size = 2
#  3 =  size = 2
#  4 =  size = 2
#  5 =  size = 2
# products =  size = 6
#  0 = "Product[id=1]"
#   id = "1"
#  1 = "Product[id=2]"
#  2 = "Product[id=3]"
#  3 = "Product[id=4]"
#  4 = "Product[id=5]"
#  5 = "Product[id=6]"
############################
```
# Response
```

# {
#   "data": {
#     "products": [
#       {
#         "id": "1",
#         "name": "Saturn V",
#         "__typename": "Product",
#         "reviews": []
#       },
#       {
#         "id": "2",
#         "name": "Lunar Module",
#         "__typename": "Product",
#         "reviews": [
#           {
#             "id": "2",
#             "starRating": 2,
#             "text": "Very cramped :( Do not recommend.",
#             "__typename": "Review"
#           },
#           {
#             "id": "2",
#             "starRating": 4,
#             "text": "Got me to the Moon!",
#             "__typename": "Review"
#           }
#         ]
#       },
#       {
#         "id": "3",
#         "name": "Space Shuttle",
#         "__typename": "Product",
#         "reviews": [
#           {
#             "id": "3",
#             "starRating": 3,
#             "text": null,
#             "__typename": "Review"
#           }
#         ]
#       },
#       {
#         "id": "4",
#         "name": "Falcon 9",
#         "__typename": "Product",
#         "reviews": [
#           {
#             "id": "4",
#             "starRating": 5,
#             "text": null,
#             "__typename": "Review"
#           },
#           {
#             "id": "4",
#             "starRating": 5,
#             "text": "Reusable!",
#             "__typename": "Review"
#           },
#           {
#             "id": "4",
#             "starRating": 5,
#             "text": null,
#             "__typename": "Review"
#           }
#         ]
#       },
#       {
#         "id": "5",
#         "name": "Dragon",
#         "__typename": "Product",
#         "reviews": [
#           {
#             "id": "5",
#             "starRating": 5,
#             "text": "Amazing! Would Fly Again!",
#             "__typename": "Review"
#           },
#           {
#             "id": "5",
#             "starRating": 5,
#             "text": null,
#             "__typename": "Review"
#           }
#         ]
#       },
#       {
#         "id": "6",
#         "name": "Starship",
#         "__typename": "Product",
#         "reviews": []
#       }
#     ]
#   }
# }
```
