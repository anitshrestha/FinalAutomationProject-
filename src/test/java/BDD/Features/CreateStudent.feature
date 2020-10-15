Feature: Student Management

  @Create
  Scenario: Verify Create Student

  Given User is in student menu
  When User clicks on new student link
  Then User verifies create heading
  When User enters last name
  And User enters first name
  And User enters enrollment date
  And User click on create button
  Then Verify User added is listed on the student list


