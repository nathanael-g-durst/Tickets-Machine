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
        val priceSub: Int = 4

      // Messages

        // Ticket selection
        val promptTicketSelection: String = "Sélectionnez la zone tarifaire correspondant à votre trajet " +
          "(1 pour Centre, 2 pour Ville et 3 pour Agglomération :"
        // Ticket Half-fare ?
        val promptHalfFare: String = "Avez-vous le demi-tarif (o/n) ? :"
        // Number of tickets
        val promptNumberTicket: String = "Combien de billets au total ? :"

    // Variables

      // Ticket selection
      var zoneSelected: Int = 0
      var isHalfFare: String = ""
      var numberTicket: Int = 0

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
      if (numberTicket < 1) {
        while (numberTicket < 1) {
          println("Le nombre de ticket ne peut pas être inférieur à 1.")
          println(promptNumberTicket)
          numberTicket = readInt()
        }
      }
  }
}
