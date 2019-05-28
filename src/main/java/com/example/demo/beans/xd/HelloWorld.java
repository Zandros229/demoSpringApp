package com.example.demo.beans.xd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class HelloWorld {
    public static    Map<Integer,MapElement> map=new HashMap<>();
    static {
        MapElement mapElement=new MapElement(0,"Janusz");
        map.put(mapElement.number,mapElement);
        mapElement=new MapElement(1,"Andrzej");
        map.put(mapElement.number,mapElement);
    }



    @Autowired
    @Qualifier("regular")
    Writer writer;

    @Autowired
    @Qualifier("fancy")
    Writer fancywirter;

    @RequestMapping("/xD")
    public String hello(){
        return fancywirter.Write("Hello World");
    }
    @RequestMapping(value = "/hello")
    public ResponseEntity<Object> getMap(){
        return new ResponseEntity<>(map.values(), HttpStatus.OK);
    }
    @RequestMapping(value = "/post")
    public ResponseEntity<Object> addToMap(@RequestBody MapElement mapElement){
    map.put(mapElement.number,mapElement);
    return new ResponseEntity<>("Product is created succesfully", HttpStatus.CREATED);
    }
//    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody MapElement mapElement) {
//        map.remove(id);
//        mapElement.number=id;
//        map.put(id, mapElement);
//        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
//    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        map.remove(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct() {
        throw new MapElementNotFound();
    }
}


