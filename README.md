Jest to kontynuacja projektu z repozytorium: [car-dealer-mvc 🚗](https://github.com/MichalBialek01/car-dealer-mvc)


## Funkcjonalności biznesowe
Projekt składa się z 4 modułów biznesowych:
* Moduł widoku sprzedawcy, w którym mamy widok na: dostępne do zakupu samochody, dostępnych sprzedaców, oraz dostępnych mechaników
* Moduł zakupowy - moduł w którym sprzedawca może wporwadzić zakup samochodyu poprzez podanie jego pełnych danych (w przypadku nowego klienta), lub sam email w przypadku istniejacego klienta. Oprócz tego wybierany jest samochód, oraz sprzedawca sprzedający.
* Moduł sprzedażowy - moduł w którym sprzedawca może wprowadzić nowego klienta zgłaszającego naprawę samochodu, oraz istniejącego klienta
* Moduł mechanika - moduł, w którym mechanik widzi zgłoszenia serwisowe, ma możliwość ich realizacji, widzi dostępne serwisy oraz częsci do wykorzystania
* Moduł widoku histrii - moduł w ktorym jest możlwiość wyświetlenia historii zakupowej

<table>
  <tr>
    <td>Moduł sprzedawcy:</td>
    <td>Moduł zakupowy:</td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/3cda9323-6f2a-427a-b439-145177f05917" alt="salesman_view"></td>
    <td><img src="https://github.com/user-attachments/assets/3f4eabe7-5769-49a9-9dfa-90f8b0b484ec" alt="car_sale_module"></td>
  </tr>
  <tr>
    <td>Moduł zgłoszeń serwisowych:</td>
    <td>Moduł mechanika:</td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/d12b7ba1-d44b-41ca-92f4-4a9420550765" alt="car_service_request_module"></td>
    <td><img src="https://github.com/user-attachments/assets/2ac6c83b-8985-4e77-a8b6-fadbf7836cdf" alt="mechanic_module"></td>
  </tr>
  <tr>
    <td>Moduł historii:</td>
    <td></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/c5f9e22e-2b11-45be-91c2-fcfbc91b865c" alt="history_module"></td>
    <td></td>
  </tr>
</table>

## Warstwa Prezentacji
Jest to warstwa odpowiedzialna za interakcję z użytkownikami naszej aplikacji.
W tym programie zostały zaimplementowane kontrolery MVC, które odpowiadają za renderowanie widoku przy pomocy silnika szablonów Thymeleaf, oraz następnie jest hostowany przez wbudowany w Spring Boot serwer aplikacyjny Tomcat.
Zaimplementowane zostały również controlery REST, które serwują dane do konsumpcji przez Frontend, lub przez innych kilentów API np. Postamn
Do kontrolerów REST zostały dodane annotacje, do generowania dokumentacji SwaggeUI dostępnej poniżej, oraz : 

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/36937424-0147c2b8-a899-42f3-9173-34e8dd1921e0?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D36937424-0147c2b8-a899-42f3-9173-34e8dd1921e0%26entityType%3Dcollection%26workspaceId%3Dd24e772e-b4d3-409e-8818-e4719d0070fb)

[Swagger Documentation](https://github.com/MichalBialek01/car-dealer-mvc-v2/blob/master/src/main/resources/swagger-ui.json)

Do obsługi błędów REST API zastosowano GlobalRestExceptionHandler, który modyfikuje wyrzucanie wyjątków poprzez stworzenie unikalnego UUID błędu i zalogowania tej infromacji:

Do obsługi błędów MVC zastosowano, GlobalExceptionHandler który obsługuje poniższe wyjątki:

MethodArgumentNotValidException -> 400 - Bad Request
BindException -> 400 - Bad Request
ProcessingException -> 500 - Internal Server Error

W celu oddzielenia warstwy prezentacji, od warstwy logiki biznesowej zastosowano klasy DTO (Data Transfer Object).
Obiekty te pozwalają na definowanie, jakie elementy struktury domenowej zostaną udostępnione użytkownikom. 
W paczce tej znajdują się również mappery mapstruct, które odpowiadają, za automatyczne mapowanie klas domenowych na DTO.  

W paczce API znajduje się również folder consume zawierający przykład konsumpcji API z wykorzystaniem OpenApiGeneator, przy pomocy ktorego mamy możlwiość pobrania losowego samochodu z wybranego województwa na podstawie zakresu dat rejestracji.


## Warstwa logiki biznesowej

Warstwa logiki biznesowej zawiera serwisy, które odpowiadają za logikę biznesową aplikacji.
Dodatkowo jest również zastosowana warstwa DAO (Data Access Object) która odziela warstwę logiki biznesowej, od warstwy persystencji.
Dzięki DAO użytkownicy warstwy biznesowej nie muszą znać szczegółów związanych z mechanizmami dostępu do danych (np. zapytaniami SQL), dzięki czemu aplikacja staje się bardziej modularna i łatwiejsza do utrzymania.
W tej paczce znajdują się również klasy domenowe, które definują obiekty do modelowania.

## Warstwa persystencji
Warstwa persystencji składa się z encji bazodanowych, repozrytoriów JPA, repozytorió wrapujących, oraz mapperów.
Encje bazodanowe definują jak wygląda schemat klasy zapisywany do bazy danych.
Repozytoria JPA pozwalają na łatwe wyciaganie danych z bazy danych. Z tych repozytoriów korzystają repozytoria wrapujące, do których wstrzykiwane są kilka repozytriów JPA w celu stworzenia złożonego zapytania do baz danych (wykorzystujący więcej niż 2 klasy )


## Warstwa Security
W tej warstwie definujemy SecurityConfiguration, UserDetailsService, Encje definujące Authroities.


## Resources
W resources znajdziemy:

* Migracje Flyway - które służą do kontrolowania wersji schematu bazy danych, automatycznej aktualizacji schematu bazy danych oraz w naszym przypadku w celach testowych do inicjalizacji danych testowych.
* Contracts - zawiera plik json stosowany przez OpenApiGenerator
* Templates - zawiera pliki html wraz z specjalnymi atrybutami Thymeleaf, które służą do dynamicznego renderowania stron HTML.

## Testy - Cooming soon  


## Stos technologiczny:

| Logo                                                                                                 | **Technologia**                       | Opis zastosowania                                                                                                                                                                          |
|------------------------------------------------------------------------------------------------------|---------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <img src="https://cdn.worldvectorlogo.com/logos/spring-3.svg" alt="Spring Boot" width="40" height="40">                                   | **Spring Boot**                       | Zarządzanie zależnościami i konfiguracja.                                                                                                                                                  |
| <img src="https://cdn.worldvectorlogo.com/logos/spring-3.svg" alt="Spring Web" width="40" height="40">                                    | **Spring Web**                        | Wystawianie REST API, działanie aplikacji poprzez model MVC. Kontrolery przekazują dane do modeli, a widoki są generowane przy pomocy Thymeleaf.                                            |
| <img src="https://cdn.worldvectorlogo.com/logos/spring-3.svg" alt="Spring Security" width="40" height="40">                               | **Spring Security**                   | Logowanie, rejestracja użytkowników oraz zarządzanie rolami administratora.                                                                                                                 |
| <img src="https://www.svgrepo.com/show/374111/swagger.svg" alt="Swagger" width="40" height="40">                                          | **Swagger i OpenAPI generator**       | Generowanie i wykorzystanie szkieletu aplikacji na podstawie dokumentacji Swagger, przy pomocy OpenAPI.                                                                                      |
| <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Postgresql_elephant.svg/640px-Postgresql_elephant.svg.png" alt="Postgres" width="40" height="40"> <img src="https://upload.wikimedia.org/wikipedia/commons/e/e1/Flyway_logo.svg" alt="FlyWay" width="40" height="40"> | **DB - Postgres, Spring JPA, FlyWay** | Inicjalizacja struktury bazy danych, przykładowe dane testowe, tworzenie użytkowników i przypisywanie odpowiednich ról.                                                                     |
| <img src="https://upload.wikimedia.org/wikipedia/commons/b/b2/Bootstrap_logo.svg" alt="Bootstrap" width="40" height="40">                  | **Bootstrap**                         | Stylowanie widoków i layoutów aplikacji.                                                                                                                                                     |
| <img src="https://seeklogo.com/images/T/thymeleaf-logo-6E4D42A713-seeklogo.com.png" alt="Thymeleaf" width="40" height="40">               | **Thymeleaf**                         | Silnik szablonów wykorzystywany do renderowania widoków po stronie serwera.                                                                                                                |
| <img src="https://junit.org/junit5/assets/img/junit5-logo.png" alt="JUnit" width="40" height="40">                                        | **JUnit**                             | Testy jednostkowe z wykorzystaniem jUnit.                                                                                                                                                   |
| <img src="https://avatars.githubusercontent.com/u/13393021?s=280&v=4" alt="Testcontainers" width="40" height="40"> <img src="https://raw.githubusercontent.com/mockito/mockito/main/src/main/javadoc/org/mockito/logo.png" alt="Mockito" width="40" height="40"> | **Testcontainers, Mockito, RestAssured, Wiremock** | Testy integracyjne z wykorzystaniem Testcontainers, Mockito, RestAssured i Wiremock - IN PROGRESS.                                                                                                       |
