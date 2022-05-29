Feature: Petshore shcemas


  @API
  Scenario: Post Request
    Given user post request icin gerekli pathprams ayarlarini yapar
    Then  user post sonrası aldıgı responsu ekrana yazdirir
    And   user gelen veriyi dogrular

  @API
  Scenario: Get Request
    Given user get request icin pathparams ayarlarini yapar
    And   user get isleminden sonra  aldigi responsu yazdırır
    And   user response ile aldiği gercek actual cevabi expected  ile karsilastirir


  @API
  Scenario: Put Request
    Given  user put islemi icin request yollar
    And    user put sonrasi aldigi responsu yazdirir
    And    user put dan gelen veriyi dogrular



  @API
  Scenario:  Delete Request
    Given user delete islemi icin request yollar
    And   user delete sonrasi aldigi responsu yazdirir
    And   user silme isleminin yapildigini dogrular