package anesu.coding;

public interface Player {

  void setPlayer(Player player);

  void sendMessage(String message);

  void receiveMessage(String message, Player sender);
}
