Feature: Delete Device

  Background:
    Given Navigate to Web Page "http://10.10.10.79:31193/signin"
    When User Enters Email "mas@maseurope.com" and Password "ma$_@8miN%" and Click Button
    Then User Should Login Successfully
    And Change language to English

  @Regression
  Scenario: TC-13 Delete Register of Unit in Register

    And User clicks following Buttons
      | burgerMenu    |
      | assetsLibrary |
      | unitMas       |

    And User search the item
      | search | TestUNIT |

    And User clicks following Buttons
      | arrowButton |

    And User switch to edit mode

    And User selects a Breadcrumb
      | registers |

    And User refresh the page

    And User clicks following Buttons
      | edit |

    And User clicks following Buttons
      | delete3 |

    And User confirms the selection
      | yes  |

    Then User should not find item
      | nameContains | TestNameDisplayEdit |



