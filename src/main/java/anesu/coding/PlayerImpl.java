package anesu.coding;

/**
 * This class represents a player (initiator) who can exchange messages with another player during a
 * game. Tracks sent messages and, for the initiator, keeps a count completed exchanges.
 */
public class PlayerImpl implements Player {

  private final String name;
  private Player player;
  private int messageCounter;
  private int totalRoundCount;

  private static final int MAX_MESSAGE_EXCHANGE_COUNT = 10;

  public PlayerImpl(String name) {
    this.name = name;
    this.messageCounter = 0;
    this.totalRoundCount = 0;
  }

  @Override
  public void setPlayer(Player player) {
    this.player = player;
  }

  @Override
  public void sendMessage(String message) {
    if (player == null) {
      System.out.println(name + " has no opposing player!");
    } else {
      messageCounter++;

      System.out.println(name + " sends: \"" + message + "\"");
      player.receiveMessage(message, this);
    }
  }


  @Override
  public void receiveMessage(String message, Player sender) {
    System.out.println(name + " received: \"" + message + "\"");

    // Count the completed exchanged responses when the initiator receives a reply from th opposing
    if (name.equals("Initiator")) {
      totalRoundCount++;

      System.out.println(
          "-> Initiator round count: " + totalRoundCount + "/" + MAX_MESSAGE_EXCHANGE_COUNT);

      if (totalRoundCount >= MAX_MESSAGE_EXCHANGE_COUNT) {
        System.out.println("Ending game. Message exchange limit has been reached!");
      }
    }

    // Include the player´s outgoing message number in the reply
    String messageResponse = message + "[Reply #" + (messageCounter + 1) + " from " + name + "]";

    if (sender != null) {
      sendMessage(messageResponse);
    }
  }
}
