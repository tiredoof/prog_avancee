package com.example.rentalService.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFoundException extends Exception{

    public CarNotFoundException(String message) {
        super(message);
    }
}

/*
* git remote add origin git@github.com:patriciaorchelle/RentalService.git
git branch -M main
git push -u origin main
*
*
*
*
*
*
*FROM openjdk:17-oracle
* openjdk:23-oracle : Utilise l'image OpenJDK version 23 avec les optimisations Oracle.
Pourquoi ? : L'image contient tout ce dont Java 23 a besoin pour exécuter votre application.
* C'est une version stable et compatible avec de nombreuses applications Java.
*
*
* VOLUME /tmp
    Description : Monte un répertoire temporaire à l'intérieur du conteneur Docker.
  Cela peut être utilisé pour stocker des fichiers temporaires générés par votre application ou Java,
    * sans que ces fichiers ne remplissent le système de fichiers du conteneur.
    *
    *
    * EXPOSE 8080
    Description : Indique que le conteneur écoute sur le port 8080.
    Pourquoi ? : Ce port est utilisé pour que d'autres applications ou utilisateurs puissent interagir avec
    * votre application Java (par exemple, via HTTP).
    *
    *
    *
* */