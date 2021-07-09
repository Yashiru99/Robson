---
title: 'Robson'
disqus: hackmd
---

Robson
===

[TOC]

## Opis działania programu

Program zaliczeniowy na przedmiot: Programowanie Obiektowe prowadzonym w semestrze letnim 2020/2021. Celem było stworzenie interpretera języka ROBSON w całości
napisanego w formacie JSON. Głownym zadaniem mojego programu jest interpretowanie języka Robson i podawanie wyniku programu zinterpretowanego oraz zmiana składni z języka napisanego w javie na język napisany w Robsonie.
Pełna treść polecenie i większa ilość przykładów: [https://students.mimuw.edu.pl/~jk417694/zadanie2.pdf](https://)

W swoim projekcie w celu deserializacji klas używałem biblioteki GSON.
Testy jednostokowe zostały napisane w przy użyciu JUnit5.

Jak kompilować program?
---
W celu kompilacji programu potrzebna jest modyfikacja zależności w pliku maven tj. Dodanie następujących linijek.

```gherkin=
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.7</version>
    <scope>compile</scope>
</dependency>
```


Przykładowy program w języku robson.
---
```json
{
"typ":"Blok",
    "instrukcje":[
        {
        "typ": "Plus",
            "argument1":{
            "wartosc": 7.0,
            "typ": "Liczba"
            },
        "argument2":{
            "wartosc": 8.0,
            "typ": "Liczba"
            }
        }
    ]
}
```
Dla takiego programu napisanego w Robsonie wyjściowy program powinien zwrócić 15, gdyż jest to wynik sumy.


## Zakończenie

:::info
**Zachęcam do zadawania pytań i zostawiania uwag!**
:::

###### tags: `Documentation`
