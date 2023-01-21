import util.Random
import javax.imageio.plugins.tiff.ExifGPSTagSet

@main def hello: Unit = 
// Define data types
  case class Troop(amount: Int) {
    override def toString(): String = 
      var str = amount.toString
      return if str.length == 1 then str + " " else str
  }
  case class Occupier(id: Option[Int]) {
    override def toString(): String = 
      id match {
        case Some(a) => a.toString()
        case None => "?"
      }
  }
  case class Continent(id: Int, states: Array[State], bonus: Int, occupier: Occupier)
  case class State(continent: Int, occupier: Occupier, troops: Troop) 
  case class Player(id: Int, hand: List[Card], states: List[State], score: Int) {
    def displayDeck: Unit =  
      var deck: Array[String] = Array.fill(6)("")
      for card_idx <- 0 to this.hand.length - 1 do
        //if card_idx == this.hand.length - 1 then
        var strArray = this.hand(card_idx).makeCard
        for i <- 0 to strArray.length - 1 do 
          deck(i) = deck(i).concat(strArray(i))
      var lastCard = this.hand(this.hand.length - 1)
      var rank = if lastCard.rank == 10.toString() then s" ${lastCard.rank}|" else s"  ${lastCard.rank}|" 
      var suit = if lastCard.suit.length == 2 then s" ${lastCard.suit}|" else s"  ${lastCard.suit}|"
      var cap: Array[String] = Array("____","   |", "   |", rank, suit,"___|")
      for i <- 0 to 5 do 
        deck(i) = deck(i).concat(cap(i))
      for i <- deck do println(i)



 

        
  }
  case class Card(suit: String, rank: String) {
    def isSameRank(other: Card): Boolean = this.rank == other.rank
    def isSameSuit(other: Card): Boolean = this.suit == other.suit
    def makeCard: Array[String] =
      var rank = if this.rank == 10.toString() then s"|${this.rank} " else s"|${this.rank}  " 
      var suit = if this.suit.length == 2 then s"|${this.suit} " else s"|${this.suit}  "
      Array("____",rank,suit,"|   ","|   ","|___") 
      //if this.suit == "<3" || this.suit == "<>" then return Array("____",s"|${this.rank}  ",s"|${this.suit} ","|   ","|   ","|___")
      //else return Array("____",s"|${this.rank}",s"|${this.suit} ","|   ","|   ","|___")


 
    /*
      var hand: Array[String] = Array("","","","","","")
      var template: Array[String] = Array("_","|","|","|","|","|")
      var rank_value: Array[String] = Array("_"," "," "," "," ","_")
      var right: Array[String] = Array("_"," "," "," "," ","_")
      rank_value(1) = this.rank
      rank_value(2) = this.suit
      // left side
      var tmp = ""
      for i <- 0 to hand.length - 1 do
        hand(i) = hand(i).concat(template(i))
      // middle
      for i <- 0 to hand.length - 1 do
        hand(i) = hand(i).concat(rank_value(i))
      for i <- 0 to hand.length - 1 do 
        if i != 2 && (this.suit != "<3" || this.suit != "<>") then hand(i) = hand(i).concat(right(i))
      for i <- hand do 
        println(i)
      hand
    */
  }
  
  // Create States and Continents
  var NAStates = Array.fill(9)(State(1, Occupier(None), Troop(0)))
  var NorthAmerica = Continent(id = 1, states = NAStates, 5, Occupier(None))
  var SAStates = Array.fill(9)(State(2, Occupier(None), Troop(0)))
  var SouthAmerica = Continent(id = 2, states = SAStates, 2, Occupier(None))
  var EStates = Array.fill(9)(State(3, Occupier(None), Troop(0)))
  var Europe = Continent(id = 3, states = EStates, 5, Occupier(None))
  var AStates = Array.fill(9)(State(4, Occupier(None), Troop(0)))
  var Africa = Continent(id = 4, states = AStates, 3, Occupier(None))

  // Create deck
  // I create the deck by giving ChatGPT the following prompt:
  // write a new data type in scala to store attributes of a card from a 52 card deck
  val suits = List("<3", "<>", "&", "^")    
  val ranks = List("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
  val deck = suits.flatMap(suit => ranks.map(rank => Card(suit, rank)))
  var shuffledDeck = Random.shuffle(deck)
  var players = new Array[Player](4)
  for (i <- 0 to 3) do
    var deck_hand = shuffledDeck.splitAt(3)
    shuffledDeck = deck_hand._2
    players(i) = Player(i+1, deck_hand._1, List[State](), 0)
    

  players(0).displayDeck



  var gameBoard = "\n"
    .concat("                      RISK: Micah Weiss                  \n")
    .concat("                                                         \n")
    .concat("         ___________________       ___________________   \n")
    .concat("   ______|    1   |   1    |       |  3  |     |     |   \n")
    .concat(s"   |     |   ${NAStates(1).occupier}:${NAStates(1).troops} |  ${NAStates(2).occupier}:${NAStates(2).troops}  |-------| ${EStates(0).occupier}:${EStates(0).troops}|  3  |     |   \n")
    .concat(s"---|  1  |________|________|       |_____| ${EStates(1).occupier}:${EStates(1).troops}|     |---\n")
    .concat(s"   | ${NAStates(0).occupier}:${NAStates(0).troops}|  1  |  1  |  1  |       |  3  |_____|     |   \n")
    .concat(s"   |_____| ${NAStates(3).occupier}:${NAStates(3).troops}| ${NAStates(4).occupier}:${NAStates(4).troops}| ${NAStates(5).occupier}:${NAStates(5).troops}|       | ${EStates(3).occupier}:${EStates(3).troops}|  3  |  3  |   \n")
    .concat(s"         |_____|_____|_____|       |_____| ${EStates(4).occupier}:${EStates(4).troops}| ${EStates(2).occupier}:${EStates(2).troops}|   \n")
    .concat(s"            |  1  |  1  |          |     |_____|     |   \n")
    .concat(s"            | ${NAStates(6).occupier}:${NAStates(6).troops}| ${NAStates(7).occupier}:${NAStates(7).troops}|          |  3  |  3  |     |   \n")
    .concat(s"            |_____|_____|          | ${EStates(5).occupier}:${EStates(5).troops}| ${EStates(6).occupier}:${EStates(6).troops}|     |   \n")
    .concat(s"               |  1  |             |_____|_____|_____|   \n")
    .concat(s"               | ${NAStates(8).occupier}:${NAStates(8).troops}|                      |            \n")
    .concat("               |_____|                      |            \n")
    .concat("                  |                         |            \n")
    .concat("  ______          |                 ________|______      \n")
    .concat("  |  1  |      ___|___              |  4  |   4   |      \n")
    .concat(s"  | ${NorthAmerica.occupier}:5 |      |  2  |              | ${AStates(0).occupier}:${AStates(0).troops}|  ${AStates(1).occupier}:${AStates(1).troops} |      \n")
    .concat(s"  |_____|      | ${SAStates(0).occupier}:${SAStates(0).troops}|              |     |_______|      \n")
    .concat(s"  |  2  |   ___|_____|___           |_____|       |      \n")
    .concat(s"  | ${SouthAmerica.occupier}:2 |   |  2  |  2  |           |  4  |   4   |      \n")
    .concat(s"  |_____|   | ${SAStates(1).occupier}:${SAStates(1).troops}| ${SAStates(2).occupier}:${SAStates(2).troops}|-----------| ${AStates(2).occupier}:${AStates(2).troops}|  ${AStates(3).occupier}:${AStates(3).troops} |      \n")
    .concat(s"  |  3  |   |_____|_____|           |_____|_______|      \n")
    .concat(s"  | ${Europe.occupier}:5 |      |  2  |              |   4   |  4  |      \n")
    .concat(s"  |_____|      | ${SAStates(3).occupier}:${SAStates(3).troops}|              |  ${AStates(4).occupier}:${AStates(4).troops} | ${AStates(5).occupier}:${AStates(5).troops}|      \n")
    .concat(s"  |  4  |      |_____|              |_______|_____|      \n")
    .concat(s"  | ${Africa.occupier}:3 |                                                \n")
    .concat(s"  |_____|          _________________________             \n")
    .concat(s" Continents        |  1  |  2  |  3  |  4  |             \n")
    .concat(s"                   |  ${players(0).score}  |  ${players(1).score}  |  ${players(2).score}  |  ${players(3).score}  |             \n") 
    .concat(s"                   |_____|_____|_____|_____|             \n")
    .concat(s"                         Player Scores                   \n")
    .concat(s"                                                         \n")

  println(gameBoard)

  // create the starting conditions for the board

 


  /*
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
    */