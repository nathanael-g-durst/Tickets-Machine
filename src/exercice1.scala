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
      var isHalfFare: String = ""
      var numberTicket: Int = 0
      var numberHalfFare: Int = 0

      // Pricing
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

    // Execute

      // Ask for zone
      println(promptTicketSelection)
      zoneSelected = readInt()

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

      // Total price computation
      if (zoneSelected == 1) {
        totalPrice = ((numberTicket - numberHalfFare) * priceCenter) + (numberHalfFare * (priceCenter/2))
        println(totalPrice)
      } else if (zoneSelected == 2) {
        totalPrice = ((numberTicket - numberHalfFare) * priceCity) + (numberHalfFare * (priceCity/2))
        println(totalPrice)
      } else if (zoneSelected == 3) {
        totalPrice = ((numberTicket - numberHalfFare) * priceSub) + (numberHalfFare * (priceSub/2))
        println(totalPrice)
      }

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

  }
}
