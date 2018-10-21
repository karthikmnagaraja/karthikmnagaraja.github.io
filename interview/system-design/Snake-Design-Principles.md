
# System Design

System design is a wide topic. Even a experienced software engineer at top IT company may not be an expert on system design. Many books, articles, and solve real large scale system design problems may needed.

## Steps (S - N - A - K - E)

-   Scenario: (Case/Interface)
-   Necessary: (Contain/Hypothesis)
-   Application: (Services/Algorithms)
-   Kilobyte: (Data)
-   Evolution

## Scenario

#### Enumerate All possible cases

-   Register / Login
-   Main Function One
-   Main Function Two
-   ...

#### Sort Requirement

Think about requirement and priority

## Necessary

-   Ask:
    -   User Number
    -   Active Users
-   Predict
    -   User
        -   Concurrent User:
            -   ![](https://latex.codecogs.com/gif.latex?Avg\_Concurrent\_Users%20=%20users_{daily\_active}%20/%20seconds_{daily}%20\times%20avg\_time_{user\_online})
        -   Peak User:
            -   ![](https://latex.codecogs.com/gif.latex?Avg\_Concurrent\_Users%20\times%20c)  : c is a constant
        -   Future Expand:
            -   Users growing: max user amount in 3 months
    -   Traffic
        -   Traffic per user (bps)
        -   MAX peak traffic
    -   Memory (< 1 TB is acceptable)
        -   Memory per user
        -   MAX daily memory
    -   Storage
        -   Type of files (e.g movie, music need to store multiple qualities)
        -   Amount of files

## Application

-   Replay the case, add a service for each request
-   Merge the services

## Kilobyte

-   Append dataset for each request below a service
-   Choose storage types

## Evolution

-   Analyze
    -   with
        -   Better: constrains
        -   Broader: new cases
        -   Deeper: details
    -   from the views of
        -   Performance
        -   Scalability
        -   Robustness
