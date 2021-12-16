package com.example.demo.Configuration.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class InternalModule extends SimpleModule {
 private static final String nombre = "InternalModule";

public InternalModule(){
super(nombre, Version.unknownVersion());



}

}
