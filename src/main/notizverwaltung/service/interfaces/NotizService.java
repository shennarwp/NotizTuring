package main.notizverwaltung.service.interfaces;


import main.notizverwaltung.model.classes.Notiz;

import java.util.List;
import main.notizverwaltung.model.classes.Kategorie;
import main.notizverwaltung.model.classes.Notiz;

import java.util.List;


import main.notizverwaltung.model.classes.Kategorie;
import main.notizverwaltung.model.classes.Notiz;

import java.util.List;


public interface NotizService {

    public Notiz getNotiz(int NotizID);
    public void addNotiz(Notiz notiz);
    public void removeNotiz(int NotizID);

    public List<Notiz> getAlleNotizenvonEinerKategorie(Kategorie kategorie);
    public List<Notiz> getAlleNotizenImNotizblock (int notizblockID);

 }