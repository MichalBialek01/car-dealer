### Car Dealership Application 

Aplikacja do zarządzania salonem samochdowym z modułami:

* **Zakupu samochodu** 
* **Zgłoszenia serwisowego**
* **Obłsugi zgłoszeń serwisowych przez mechaników**

Widok główny modułu sprzedawcyS:
![salesman.png](salesman_view.png)
Widok modułu zakupowego: 
![car_sale_module.png](car_sale_module.png)
Widok modułu zgłoszeń serwisowych:
![car_service_request_module](car_service_request_module.png)
Widok mechanika:
![mechanic_module.png](mechanic_module.png)
Widok modułu histori:
![history_module.png](history_module.png)

Aplikacja została napisanie w architekturze 3 warstwowej.

Technology stack:

[//]: # (1. **Spring Boot** - zarządzanie zależnościami i konfiguracja)

[//]: # (3. **Spring Web** - Wystawianie REST API, oraz działanie aplikacji poprzez model MVC )

[//]: # (&#40;Kontrolery przekazujące dane do modeli ich wykorzystanie do generowania widoku przy pomocy silnika szablonów Thymeleaf&#41; )

[//]: # (2. **Spring Security** - logowanie, oraz rejrestracja użytkownikow, oraz rola administratora.)

[//]: # (3. **Swagger i OpenAPI generator** - Na podstawie dokumentacji Swagger, przy pomocy OpenAPI wygenerowałem i wykorzystałem szkielet aplikacji)

[//]: # (4. **DB - Postgres, SprignJPA,FlyWay** – inicjalizacja struktury bazy danych, inicjalizacja przykładowymi danymi testowymi, oraz do tworzenia użytkowników wraz z odpowiednimi rolami)

[//]: # (5. **Testy jednostkowe** - jUnit, assertJ.)

[//]: # (6. **Test integracyjne** z wykorzystaniem testcontainers – Mockito, RestAssured i Wiremock)

[//]: # ()

| Logo                                                                                                                                                                                                                                                                           | **Technologia**                      | Opis zastosowania                                                                                                                                                                      |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|                                                                                                                                                                                                                                                                                | **Spring Boot**                      | Zarządzanie zależnościami i konfiguracja.                                                                                                                                              |
| ![Spring Web logo](https://cdn.worldvectorlogo.com/logos/spring-3.svg)                                                                                                                                                                                                         | **Spring Web**                       | Wystawianie REST API, oraz działanie aplikacji poprzez model MVC. Kontrolery przekazujące dane do modeli, wykorzystanie do generowania widoku przy pomocy silnika szablonów Thymeleaf. |
|                                                                                                                                                                                                                                                                                | **Spring Security**                  | Logowanie, rejestracja użytkowników, oraz zarządzanie rolami administratora.                                                                                                           |
| ![Swagger logo](https://camo.githubusercontent.com/a1b132bbb48c1d919861d62805932eca6ac2fa662c03300d2e4bf418071c1956/68747470733a2f2f7777772e7376677265706f2e636f6d2f73686f772f3337343131312f737761676765722e737667)                                                            | **Swagger i OpenAPI generator**      | Generowanie i wykorzystanie szkieletu aplikacji na podstawie dokumentacji Swagger, przy pomocy OpenAPI.                                                                                |
| ![Postgres logo](https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Postgresql_elephant.svg/640px-Postgresql_elephant.svg.png)             ![FlyWay](https://upload.wikimedia.org/wikipedia/commons/e/e1/Flyway_logo.svg)                                               | **DB - Postgres, SpringJPA, FlyWay** | Inicjalizacja struktury bazy danych, przykładowe dane testowe, tworzenie użytkowników i przypisywanie odpowiednich ról.                                                                |
| ![Bootstrap](https://upload.wikimedia.org/wikipedia/commons/b/b2/Bootstrap_logo.svg)   ![Thymeleaf](https://seeklogo.com/images/T/thymeleaf-logo-6E4D42A713-seeklogo.com.png)   ![Tomcat ](https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Apache_Tomcat_logo.svg/640px-Apache_Tomcat_logo.svg.png)           | **Widok,silnik szablonów oraz serwer aplikacji**     |                                                                                                                                                                                        |
| ![JUnit logo](https://junit.org/junit5/assets/img/junit5-logo.png)                                                                                                                                                                                                             | **Testy jednostkowe**                | Testy jednostkowe z wykorzystaniem jUnit.                                                                                                                                              |
| ![Testcontainers logo](https://avatars.githubusercontent.com/u/13393021?s=280&v=4) ![Testcontainers logo](https://avatars.githubusercontent.com/u/21368587?s=280&v=4) ![Mockito](https://raw.githubusercontent.com/mockito/mockito/main/src/main/javadoc/org/mockito/logo.png) | **Testy integracyjne**               | Testy integracyjne z wykorzystaniem Testcontainers, Mockito, RestAssured i Wiremock.                                                                                                   |

