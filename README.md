# Loose coupling with Apache Camel

In this example there are 3 Modules.
When you run it, you should receive a similar output.

```
    Calculated summary 81 + 95 = 176 
    Calculated summary 31 + 3 = 34 
    Calculated summary 59 + 13 = 72 
    Calculated summary 81 + 70 = 151
```

The first two numbers are created in one module (producer) and the result is calculated in another (consumer).
Both modules are completely independent to each other and share no code base.

Theoretically one could extract the whole module and put it in a microservice. Only the route needs to be changed and everything stays the same.

## App - Run the application

Contains the main application which knows all the other modules and loads the whole application context

Use ***DemoApplication:main*** to run the app

# Producer

Creates a random message with two numbers and sends it via camel to the consumer. It waits for the response and logs it out

# Consumer

Consumes a message via camel, calculates a summary and returns it.