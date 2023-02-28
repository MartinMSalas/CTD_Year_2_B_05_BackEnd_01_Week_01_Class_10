package com.salasmartin.clase11.figuras;

import java.io.IOException;

public class SoundController {
  public static void main(String[] args) throws IOException, InterruptedException {
    // Mute the system sound
    Runtime.getRuntime().exec("powershell.exe Set-Volume -Mute true");
    System.out.println("System sound muted.");

    // Wait for 5 seconds
    Thread.sleep(5000);

    // Unmute the system sound
    Runtime.getRuntime().exec("powershell.exe Set-Volume -Mute false");
    System.out.println("System sound unmuted.");
  }
}