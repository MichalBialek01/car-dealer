
# Car Dealership Application

## Opis funkcjonalności biznesowych:

Aplikacja jest kompleksowym systemem do zarządzania salonem samochodowym, obejmującym trzy główne moduły:

1. **Moduł zakupu samochodu** – Pozwala użytkownikom na przeglądanie dostępnych samochodów, składanie zamówień oraz finalizację zakupu.
2. **Moduł zgłoszeń serwisowych** – Klienci mogą zgłaszać potrzebę serwisowania swoich pojazdów, śledzić status napraw oraz zarządzać harmonogramem wizyt.
3. **Moduł obsługi zgłoszeń przez mechaników** – Mechanicy mogą zarządzać zgłoszeniami serwisowymi, aktualizować status napraw oraz zarządzać swoim harmonogramem pracy.


<style>
  table {
    width: 100%;
  }
  td {
    text-align: center;
    padding: 10px;
  }
  img {
    width: 150px;
    height: auto;
    transition: transform 0.2s;
  }
  img:hover {
    transform: scale(1.5);
  }
</style>

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

## Architektura

Aplikacja została zaprojektowana w architekturze trójwarstwowej, co zapewnia modularność i łatwość w utrzymaniu kodu:

1. **Warstwa prezentacji (frontend)** – Odpowiada za interakcję użytkownika z aplikacją. Opiera się na technologii **Thymeleaf**, która umożliwia generowanie dynamicznych widoków HTML po stronie serwera.

2. **Warstwa logiki biznesowej (backend)** – Obsługuje logikę aplikacji, w tym przetwarzanie żądań użytkownika oraz zarządzanie procesami biznesowymi, takimi jak sprzedaż i serwis. Używa **Spring Boot** do zarządzania zależnościami i konfiguracji oraz **Spring Web** do obsługi REST API.

3. **Warstwa dostępu do danych** – Zajmuje się operacjami na bazie danych. Wykorzystuje **Spring JPA** do mapowania obiektowo-relacyjnego (ORM) i integracji z bazą **PostgreSQL** oraz narzędzie **FlyWay** do zarządzania migracjami bazy danych.

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
| <img src="https://avatars.githubusercontent.com/u/13393021?s=280&v=4" alt="Testcontainers" width="40" height="40"> <img src="https://raw.githubusercontent.com/mockito/mockito/main/src/main/javadoc/org/mockito/logo.png" alt="Mockito" width="40" height="40"> | **Testcontainers, Mockito, RestAssured, Wiremock** | Testy integracyjne z wykorzystaniem Testcontainers, Mockito, RestAssured i Wiremock.                                                                                                       |

Aplikacja wykorzystuje również integrację z **Postman** oraz **Swagger** do testowania API i dokumentacji, a także szeroko zakrojone testy jednostkowe i integracyjne przy pomocy narzędzi takich jak **JUnit**, **Testcontainers**, **Mockito**, **RestAssured** i **Wiremock**.

Projekt wspiera architekturę opartą na REST API, a dodatkowe szczegóły dotyczące działania modułów oraz możliwości można znaleźć w dokumentacji Swagger dostępnej w projekcie.
