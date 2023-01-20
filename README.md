# MyRisk
## Equipment:
* The game board includes 26 connected states, four continents, a continent bonus leaderboard, and a player score leaderboard. A state is a cell on the board that players occupy with troops. Troops are units players use to defend or attack states. Continents are collections of states. Players have 3 available dice for attacks and 2 dice for defending. They also receive cards from a 52 card deck that they can exchange for troops. 

## Rules:
* Points:
    * The number of points each player has is equal to the number of states occupied plus the bonus incurred by occuping a continent. Continent bonuses are depected on the side of the map. The top number in each box is continent, the left value (default: ?) is who occupies the continent, and the right value is the continent bonus. The top number in each state signifies the continent it belongs to. 
* Attacking & Defending:
    - Attacking: 
        * A player, player1, may only attack the state of an opponent, player2, if player1 has a state with more than 1 troop that is also adjacent to player2's state. 
        * When attacking, player1 chooses the number of troops to attack with. Players can attack with no less than 1 troop and no more than 3 toops, but they cannot use every troop on their state. At least one must be left in reserve. The number of troops is equal to the number of attack dice player1 will roll. 
    - Defending:
        * To defend, player2 can use 1 or 2 troops of their available troops. The number of troops used is equal to the number of defend dice player 2 will roll.
    - The highest attack and defend dice rolled will be used. If player1 rolls 3 dice, a 1, 3 and 6, and player2 rolls 2 dice, a 2 and a 6, player1 will play the 3 and 6 while player2 will play the 2 and 6 (They must play all of their rolled dice if player1 rolls the same number of more dice). Ties go to the defender, so player2's 6 beats player1's 6. Player1's 3 beats player2's 2. Therefore, each player loses 1 troop.
* Starting a turn:
    * To start a turn, the player can place any card sets they posses for additional troops. A pair of the same suit or value rewards the player 2 troops, three of a kind is 4 troops, and 4 of a kind is 6 troops. The player is also awarded troops equal to the points they have divided by 3 (rounding down). Points are depicted on the bottom of the board, where the top number is a players number and the bottom number is the points they possess. A player can place troops on any state they occupy. After placing troops, they can attack. 
* Ending a turn:
    * After their attack, a player can move move troops from one state to an adjacent state. They can move x troops, where x is equal to the number of troops on the state minus one. If during their attack phase, they successfully conquered a state, they draw another card from the deck to end their turn. 
* Starting the game:
    * Each player starts out with 30 troops and 3 cards. Starting with the player of the lowest id, ie player1, and continueing in increasing order, players take turns placing one troop in any state that isn't occupied by another player. 
* Winning the game:
    * To win the game, a player must occupy every state on the board. 