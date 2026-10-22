package anesu.coding;

public class Main {
  public static void main(String[] args) {
    // 1. Create two player instances using the interface type

    PlayerImpl initiator = new PlayerImpl("Initiator");
    PlayerImpl player = new PlayerImpl("Responding Player");

    // Wire both players together
    initiator.setPlayer(player);
    player.setPlayer(initiator);

    // Conversation starts
    System.out.println("--Starting Game --");
    initiator.sendMessage("Hello! Ready to begin the game?");
  }
}
