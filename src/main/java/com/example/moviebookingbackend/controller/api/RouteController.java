package com.example.moviebookingbackend.controller.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping
    public List<String> getAllRoutes() {
        return requestMappingHandlerMapping.getHandlerMethods().keySet()
                .stream()
                .map(request -> request.toString())
                .collect(Collectors.toList());
    }
}