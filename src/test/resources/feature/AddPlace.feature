Feature: Work with AppPlaceAPI


  @addPlace
  Scenario Outline: User is able to add the place

    Given User sets the request using following parameter <accuracy>,"<name>","<phone_number>","<address>","<website>","<language>",<lat>,<lng>
    When User sends the POST request with "<endpoint>"
    Then User Validates responseCode as <code>
    Examples:
      |endpoint                            |accuracy                |name               |phone_number        |address                     |website                        |language       |lat              |lng                  |code          |
      |/maps/api/place/add/json            |     50                 | Frontline house   |(+91) 983 893 3937  | 9, side layout, cohen 09   | http://google.com             |French-IN      |-38.383494       | 33.427362           | 200          |