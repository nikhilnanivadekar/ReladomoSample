# ReladomoSample

This project is created to showcase different features of Reladomo.
It is setup with two domains: [Simple](https://github.com/nikhilnanivadekar/ReladomoSample#simple-domain) and [Complex](https://github.com/nikhilnanivadekar/ReladomoSample#complex-domain).

# Simple Domain
## Description

This domain is useful to understand concepts like Finders, Attributes and Relationships.
Simple domain consists of three objects `Person`, `Pet` and `PetType`. 
- `Person` and `Pet` are related as one to many, meaning one `Person`, can have many `Pet`s.
  - There exists a reverse relationship between `Person` and `Pet` which helps the users traverse from `Pet` to `Person` and well as from `Person` to `Pet`. 
- `Pet` to `PetType` is many to one, i.e. many `Pet`s can be of one `PetType`. 
  - `Pet` to `PetType` relationship is uni-directional, hence the users can only traverse from `Pet` to `PetType`.
The entire domain is considered to be in a single database without any shards, none of the objects are temporal.

## Class Diagram
![Class Diagram](https://github.com/nikhilnanivadekar/ReladomoSample/blob/master/SimpleDomain.png)

# Complex Domain
## Description

This domain is useful to understand complex concepts like Sharding, Uni-temporal, Bi-temporal chaining, Advanced Finders, Advanced Relationships.
Complex domain consists of five objects `Account`, `Product`, `ProductSynonym`, `Trade`, `Balance`.
- `Account`, `Product`, `ProductSynonym` are non-sharded objects, i.e. their schema exists in only one database.
- `Trade` and `Balance` are sharded objects, i.e. their schema exists in more than one database.
This helps us elaborate the support for only sharded domains, only non-sharded domains as well as a mix of sharded and non-sharded domains in Reladomo.

- `ProductSynonym` is a non-temporal object.
- `Account`, `Balance`, `Product`, `Trade` are bi-temporal objects. There exists both `businessDate` and `processingDate` dimensions.
  * These objects are considered to capture a system's activity w.r.t. trades and balances. It is possible that we need to make an 'as-of' correction to the data. Hence, they are created as bi-temporal objects which will enable us to preserve history as well as edit it.
This helps us demonstrate the out of box support for temporal objects available in Reladomo.
 
- Relationships in this domain can be better understood using the class diagram below. 
These relationships are setup such that:
- You can query the same object using a different attribute a.k.a. self-join. Example: `tradesByTradeRef`
- You can query objects with a fixed parameter in the join condition a.k.a. parameterized relationship. Example: `cusOrFooSynonyms`
- You can query objects with a variable parameter in the join condition a.k.a. parameterized relationship. Example: `synonymByType`
- There are also few simple relationships similar to the ones in Simple Domain.

## Class Diagram
![Class Diagram](https://github.com/nikhilnanivadekar/ReladomoSample/blob/master/ComplexDomain.png)
