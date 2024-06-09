package io.github.yuokada;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
    info = @Info(
        title = "Todo API Endpoints",
        version = "0.1.0",
        description = "Here is description of Todo API.",
        license = @org.eclipse.microprofile.openapi.annotations.info.License(
            name = "MIT License",
            url = "https://opensource.org/licenses/MIT"
        )
    ),
    // Or setting quarkus.smallrye-openapi.auto-add-server to true in application.properties
    //    servers = {
    //        @Server(url = "http://localhost:8080", description = "Local server")
    //    },
    tags = {
        @Tag(name = "Todo core API", description = "Todo API endpoints")
    }
)
public class TodoApplication {

}
