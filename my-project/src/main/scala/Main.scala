@main def hello: Unit = 
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





  /*

  "  ____________________________________        ___________________________   \n" 
    "  |        |      1      |      1     |       |    3   |        |        |  \n" +
    "  |        |             |            |-------|2(2,4,5)|    3   |        |  \n" +
    "--|    1   |_____________|____________|       |________|2(2,4,5)|        |--\n" +
    "  |1(1,0,0)|    1   |    1   |    1   |       |    3   |________|        |  \n" +
    "  |        |1(1,0,0)|2(2,4,5)|2(2,4,5)|       |2(2,4,5)|    3   |    3   |  \n" +
    "  |________|________|________|________|       |________|2(2,4,5)|2(2,4,5)|  \n" +
    "           |      1      |      1     |       |        |________|        |  \n" +
    "           |             |            |       |    3   |    3   |        |  \n" +
    "           |_____________|____________|       |2(2,4,5)|2(2,4,5)|        |  \n" +
    "           |             1            |       |________|________|________|  \n" +
    "           |                          |                     |               \n" +
    "           |__________________________|                     |               \n" +
    "                         |                    ______________|______         \n" +
    "                         |                    |    4   |     4     |        \n" +
    "                _________|________            |2(2,4,5)|  2(2,4,5) |        \n" +
    "                |        2        |           |        |___________|        \n" +
    "                |    2(2,4,5)     |           |________|           |        \n" +
    "                |_________________|           |    4   |     4     |        \n" +
    "                |    2   |    2   |-----------|        |           |        \n" +
    "                |2(2,4,5)|2(2,4,5)|           |________|___________|        \n" +
    "                |________|________|           |     4    |    4    |        \n" +
    "                |        2        |           |          |         |        \n" +
    "                |    2(2,4,5)     |           |__________|_________|        \n" +
    "                |_________________|                                         \n" +
    "                                                                            \n" +
    "                                                                            \n" +
    "                                                                            \n" +
    "                                                                            \n" +
    "                                                                            \n" +
    "                                                                            \n" +
    "                                                                            \n" +
    "                                                                            \n" +
*/