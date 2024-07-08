# project-api-in-nuvem

## Diagrama de classes

```mermaid
classDiagram
    class Usuario {
        -String name
        -Account account
        -List~Feature~ features
        -Card card
        -List~News~ news
    }

    class Account {
        -String number
        -String agency
        -float balance
        -float limit
    }

    class Feature {
        -String icon
        -String description
    }

    class Card {
        -String number
        -float limit
    }

    class News {
        -String icon
        -String description
    }

    Usuario --> Account
    Usuario --> Feature
    Usuario --> Card
    Usuario --> News
```mermaid

