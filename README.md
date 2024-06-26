# quarkus quinoa sample application

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website:
https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_** Quarkus now ships with a Dev UI, which is available in dev mode
> only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the
`target/quarkus-app/lib/` directory.

The application is now runnable using
`java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using
`java -jar target/*-runner.jar`.

If you want to learn more about building native executables, please consult
https://quarkus.io/guides/maven-tooling.

## Related Guides

- AWS Lambda ([guide](https://quarkus.io/guides/amazon-lambda)): Write AWS
  Lambda functions
- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A
  JAX-RS implementation utilizing build time processing and Vert.x. This
  extension is not compatible with the quarkus-resteasy extension, or any of the
  extensions that depend on it.
- AWS Lambda Gateway REST API
  ([guide](https://quarkus.io/guides/amazon-lambda-http)): Build an API Gateway
  REST API with Lambda integration
