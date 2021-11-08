// Imports
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

// Main
object exercice1 {
  def main(args: Array[String]): Unit = {
    // Values

      // Tickets and prices

        // Centre
        val nameCenter: String = "Centre"
        val priceCenter: Int = 2
        // Ville
        val nameCity: String = "Ville"
        val priceCity: Double = 2.4
        // Agglomération
        val nameSub: String = "Agglomération"
        val priceSub: Int = 3

      // Messages

        // Ticket selection
        val promptTicketSelection: String = "Sélectionnez la zone tarifaire correspondant à votre trajet " +
          "(1 pour Centre, 2 pour Ville et 3 pour Agglomération :"
        // Ticket Half-fare ?
        val promptHalfFare: String = "Avez-vous le demi-tarif (o/n) ? :"
        // Number of tickets
        val promptNumberTicket: String = "Combien de billets au total ? :"
        // Number of half-fare tickets
        val promptNumberHalfFare: String = "Dont combien de billets demi-tarifs ?"
        // Ask for money
        val promptAskMoney: String = "Saisissez le montant de la pièce que vous insérez :"
        // Ask for order confirmation
        val promptConfirmOrder: String = "Confirmez-vous l’achat (o/n) ?"
        // Give change back when order canceled
        val promptChangeCancelled: String = "Retour de votre monnaie :"
        // Ticket thank you message
        val promptThankYou: String = "Les transports Scala vous souhaitent un bon trajet"
        // Give change back when order confirmed
        val promptChangeConfirmed: String = "Votre monnaie : "

      // Errors

        // Number of tickets lower than 1
        val errorNumberTicket: String = "Le nombre de ticket ne peut pas être inférieur à 1."
        // Number of half-fare higher than tickets
        val errorNumberHalfFare: String = "Le nombre de ticket demi-tarifs ne peut pas être supérieur au nombre total de billets."
        // Invalid coin inserted
        val errorCoin: String = "cette pièce n’est pas acceptée"

    // Variables

      // Ticket selection
      var zoneSelected: Int = 0
      var zoneName: String = ""
      var isHalfFare: String = ""
      var numberTicket: Int = 0
      var numberHalfFare: Int = 0
      var numberFullFare: Int = 0

      // Pricing
      var priceTicket: Double = 0
      var priceHalfFare: Double = 0
      var totalPrice: Double = 0
      var totalCoin: Double = 0
      var coinInserted: Int = 0
      var countCoinFive: Int = 0
      var countCoinTwo: Int = 0
      var countCoinOne: Int = 0
      var countCoinFifty: Int = 0
      var countCoinTwenty: Int = 0
      var countCoinTen: Int = 0
      var confirmOrder: String = ""
      var change: Double = 0
      var changeString: String = ""
      var test: String = ""

  // Functions

      // Change string writer
      def stringWriter (remainingChange:Double, coinValue:Int, coinNumber:Int): String = {
        var changeStringWriter: String = s"$coinNumber"
        if (coinNumber == 1) {
          changeStringWriter = s"$changeStringWriter pièce de"
        } else if (coinNumber > 1) {
          changeStringWriter = s"$changeStringWriter pièces de"
        }
        if (coinNumber > 0) {
          changeStringWriter = s"$changeStringWriter $coinValue CHF"
          if (remainingChange > 0) {
            changeStringWriter = s"$changeStringWriter, "
          } else {
            changeStringWriter = s"$changeStringWriter"
          }
        } else {
          changeStringWriter = ""
        }
        return changeStringWriter
      }

    // Execute

      // Ask for zone and define price
      println(promptTicketSelection)
      zoneSelected = readInt()
      if (zoneSelected == 1) {
        priceTicket = priceCenter
        priceHalfFare = priceCenter*0.5
        zoneName = nameCenter
      } else if (zoneSelected == 2) {
        priceTicket = priceCity
        priceHalfFare = priceCity*0.5
        zoneName = nameCity
      } else if (zoneSelected == 3) {
        priceTicket = priceSub
        priceHalfFare = priceSub*0.5
        zoneName = nameSub
      }

    // Ask for half-fare
      println(promptHalfFare)
      isHalfFare = readLine()

      // Ask for total number of tickets
      println(promptNumberTicket)
      numberTicket = readInt()

      // Error when ticket isn't at least 1
      while (numberTicket < 1) {
        println(errorNumberTicket)
        println(promptNumberTicket)
        numberTicket = readInt()
      }

      // Number of half-fare tickets
      if (isHalfFare == "o") {
        println(promptNumberHalfFare)
        numberHalfFare = readInt()
        // Error when more half-fare tickets than total
        while (numberHalfFare > numberTicket) {
          println(errorNumberHalfFare)
          println(promptNumberHalfFare)
          numberHalfFare = readInt()
        }
      }

      // Number of full fare tickets and half fare price for simplicity
      numberFullFare = numberTicket - numberHalfFare

      // Total price computation
      totalPrice = numberFullFare * priceTicket + numberHalfFare * priceHalfFare

      // Ask for payment
      while (totalCoin < totalPrice) {
        println(promptAskMoney)
        coinInserted = readInt()
        // Update coin counter
        if (coinInserted == 5) {
          countCoinFive += 1
        } else if (coinInserted == 2) {
          countCoinTwo += 1
        } else if (coinInserted == 1) {
          countCoinOne += 1
        } else if (coinInserted == 50) {
          countCoinFifty += 1
        } else if (coinInserted == 20) {
          countCoinTwenty += 1
        } else if (coinInserted == 10) {
          countCoinTen += 1
        } else {
          println(errorCoin)
        }
        // Check amount inserted
        totalCoin = (countCoinFive*5)+(countCoinTwo*2)+countCoinOne+(countCoinFifty*0.5)+(countCoinTwenty*0.2)+(countCoinTen*0.1)
        println(s"Inserted: $totalCoin out of $totalPrice")
      }

      // Ask for confirmation
      println(promptConfirmOrder)
      confirmOrder = readLine()

      // Process the order (cancelled order or printing tickets)
      if (confirmOrder == "n") {
        println(promptChangeCancelled)
        if (countCoinFive == 1) {
          changeString = s"$countCoinFive pièce de 5 CHF, "
        } else if (countCoinFive > 1) {
          changeString = s"$countCoinFive pièces de 5 CHF, "
        }
        if (countCoinTwo == 1) {
          changeString = s"$countCoinTwo pièce de 2 CHF, "
        } else if (countCoinTwo > 1) {
          changeString = s"$countCoinTwo pièces de 2 CHF, "
        }
        if (countCoinOne == 1) {
          changeString = s"$countCoinOne pièce de 1 CHF, "
        } else if (countCoinOne > 1) {
          changeString = s"$countCoinOne pièces de 1 CHF, "
        }
        if (countCoinFifty == 1) {
          changeString = s"$countCoinFifty pièce de 50 Centimes, "
        } else if (countCoinFifty > 1) {
          changeString = s"$countCoinFifty pièces de 50 Centimes, "
        }
        if (countCoinTwenty == 1) {
          changeString = s"$countCoinTwenty pièce de 20 Centimes, "
        } else if (countCoinTwenty > 1) {
          changeString = s"$countCoinTwenty pièces de 20 Centimes, "
        }
        if (countCoinTen == 1) {
          changeString = s"$countCoinTen pièce de 10 Centimes, "
        } else if (countCoinTen > 1) {
          changeString = s"$countCoinTen pièces de 10 Centimes, "
        }
      } else if (confirmOrder == "o") {
            println(s"Ticket zone tarifaire : $zoneName")
            println(s"Plein tarif : $numberFullFare")
            println(s"Demi-tarif : $numberHalfFare")
            println(s"Montant total TTC : $totalPrice")
            println(promptThankYou)

            // Change
            if (totalPrice != totalCoin) {

              change = (totalCoin - totalPrice) * 100
              change = change.toInt

              // Reset counters
              countCoinFive = 0
              countCoinTwo = 0
              countCoinOne = 0
              countCoinFifty = 0
              countCoinTwenty = 0
              countCoinTen = 0

              // Count change
              while (change / 500 >= 1) {
                countCoinFive += 1
                change = change - 500
              }
              while (change / 200 >= 1) {
                countCoinTwo += 1
                change = change - 200
              }
              while (change / 100 >= 1) {
                countCoinOne += 1
                change = change - 100
              }
              while (change / 50 >= 1) {
                countCoinFifty += 1
                change = change - 50
              }
              while (change / 20 >= 1) {
                countCoinTwenty += 1
                change = change - 20
              }
              while (change / 10 >= 1) {
                countCoinTen += 1
                change = change - 10
              }

              // Give change back
              if (countCoinFive >= 1) {
                changeString = s"$countCoinFive de 5 CHF, "
              }
              if (countCoinTwo >= 1) {
                changeString = s"$changeString$countCoinTwo de 2 CHF, "
              }
              if (countCoinOne >= 1) {
                changeString = s"$changeString$countCoinOne de 1 CHF, "
              }
              if (countCoinFifty >= 1) {
                changeString = s"$changeString$countCoinFifty de 50 Centimes, "
              }
              if (countCoinTwenty >= 1) {
                changeString = s"$changeString$countCoinTwenty de 20 Centimes, "
              }
              if (countCoinTen >= 1) {
                changeString = s"$changeString$countCoinTen de 10 Centimes"
              }
              println(s"$promptChangeConfirmed$changeString")
            }
      }
  }
}
