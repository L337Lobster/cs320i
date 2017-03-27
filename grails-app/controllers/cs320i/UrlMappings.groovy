package cs320i

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "jhofmann", action: "index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
