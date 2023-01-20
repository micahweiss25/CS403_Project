import util.Random

@main def hello: Unit = 
// Define data types
  case class Continent(id: Int, states: Array[State], bonus: Int)
  case class State(continent: Int, occupier: Option[Int], troops: Int)
  case class Player(id: Int, hand: List[Card], states: List[State], points: Int) 
  case class Card(suit: String, rank: String) {
    def isSameRank(other: Card): Boolean = this.rank == other.rank
    def isSameSuit(other: Card): Boolean = this.suit == other.suit
  }
  var NAStates = Array.fill(9)(State(1, None, 0))
  var NorthAmerica = Continent(id = 1, states = NAStates, 5)
  // Create deck
  // I create the deck by giving ChatGPT the following prompt:
  // write a new data type in scala to store attributes of a card from a 52 card deck
  val suits = List("hearts", "diamonds", "clubs", "spades")
  val ranks = List("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
  val deck = suits.flatMap(suit => ranks.map(rank => Card(suit, rank)))
  val shuffledDeck = Random.shuffle(deck)

  // Divde map






  var gameBoard = "\n"
    .concat("                      RISK: Micah Weiss                  \n")
    .concat("                                                         \n")
    .concat("         ___________________       ___________________   \n")
    .concat("   ______|    1   |   1    |       |  3  |     |     |   \n")
    .concat("   |     |   4:5  |  3:5   |-------| 3:5 |  3  |     |   \n")
    .concat("---|  1  |________|________|       |_____| 4:5 |     |---\n")
    .concat("   | 4:5 |  1  |  1  |  1  |       |  3  |_____|     |   \n")
    .concat("   |_____| 3:5 | 3:4 | 3:1 |       | 4:4 |  3  |  3  |   \n")
    .concat("         |_____|_____|_____|       |_____| 4:5 | 4:3 |   \n")
    .concat("            |  1  |  1  |          |     |_____|     |   \n")
    .concat("            | 3:5 | 3:5 |          |  3  |  3  |     |   \n")
    .concat("            |_____|_____|          | 4:3 | 2:7 |     |   \n")
    .concat("               |  1  |             |_____|_____|_____|   \n")
    .concat("               | 1:11|                      |            \n")
    .concat("               |_____|                      |            \n")
    .concat("                  |                         |            \n")
    .concat("  ______          |                 ________|______      \n")
    .concat("  |  1  |      ___|___              |  4  |   4   |      \n")
    .concat("  | ?:5 |      |  2  |              | 2:7 |  2:2  |      \n")
    .concat("  |_____|      | 1:3 |              |     |_______|      \n")
    .concat("  |  2  |   ___|_____|___           |_____|       |      \n")
    .concat("  | ?:2 |   |  2  |  2  |           |  4  |   4   |      \n")
    .concat("  |_____|   | 1:1 | 1:3 |-----------| 1:11|  2:5  |      \n")
    .concat("  |  3  |   |_____|_____|           |_____|_______|      \n")
    .concat("  | ?:5 |      |  2  |              |   4   |  4  |      \n")
    .concat("  |_____|      | 1:1 |              |  2:7  | 2:2 |      \n")
    .concat("  |  4  |      |_____|              |_______|_____|      \n")
    .concat("  | ?:3 |                                                \n")
    .concat("  |_____|          _________________________             \n")
    .concat(" Continents        |  1  |  2  |  3  |  4  |             \n")
    .concat("                   |  6  |  6  |  7  |  7  |             \n")
    .concat("                   |_____|_____|_____|_____|             \n")
    .concat("                         Player Scores                   \n")
    .concat("                                                         \n")

  println(gameBoard)


