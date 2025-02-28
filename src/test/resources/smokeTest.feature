Feature: Key functionality/Telstar - NTDUY

  Scenario Outline: Automated TC1: User can login with invalid username and password (Unhappy case)
    Given user visits the portal
    When user inputs "<username>" and "<password>"
    Then User can see error message

    Examples:
      | username                  | password |
      | ntduy                     |invalidPassword |

  Scenario Outline: Automated TC2: User can login TL website (Happy case)
    Given user visits the portal
    When user inputs "<username>" and "<password>"
    Then verify the user had been succesfully log in

    Examples:
      | username                | password |
      | admin                   | admin |

  Scenario: Automated TC3: User - log in TL website - add a new user
    Given user visits the portal
    Then user inputs "admin" and "admin"
    And admin navigates to "User Management"
    Then admin user add a new member