@Regression
Feature: Registration Feature
@Smoke
  Scenario Outline: verify user can register with valid username and email (positive)
    Given  user is at home page
    When he clicks on register tap
    And  choose his "<Round>"
    And  enters his Fname "<FirstName>"
    And  enters his Secondname "<SecondName>"
    And select his Day "<Day>"
    And select his Month "<Month>"
    And select his Year "<Year>"
    And  enters his Company "<CompanyName>"
    And enters his valid "<email>"
    And check on newsletter button
    And enters and confirms his "<Password>"
    And clicks on register button
    Then a successful message "Your registration completed" should be displayed
    And a continue button should be displayed

    Examples:
      |Round ||FirstName||SecondName||Day||Month||Year||CompanyName||email||Password|
      |  Male || she    ||name      ||12 ||1   ||1999||firm1 ||tets52@example.com||123456|
      | Female|| alice  ||father    ||13 ||2   ||1989||company55 ||tets55@example.com||0123456|

