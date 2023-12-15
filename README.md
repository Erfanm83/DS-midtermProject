# WaterSort Console Game

A console-based WaterSort game where you pour water between bottles, trying to arrange them by color.

## Overview

The WaterSort game is a console application that simulates a water pouring puzzle. The player enters the number of colors and the maximum size of every bottle. The game randomly distributes colors among the bottles, and the player's objective is to pour bottles as long as there's a bottle containing only one color.

## Features

- **Random Color Distribution:** The game starts with randomly distributed colors in each bottle.
- **Pouring Logic:** Pour water between bottles to group colors together.
- **Victory Condition:** Win the game by successfully grouping all colors into individual bottles.

## Getting Started

### Prerequisites

- Java installed on your machine.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Erfanm83/DS-midtermProject.git
   cd WaterSortGame

2. Compile the Java code:
   ```bash
   javac WaterSortGame.java
   javac main.java
   javac.Clinkedlist.java
   
3. Run the game:
    ```bash
   java main

### Usage

  1. Run the game as described in the installation section.
  2. Enter the number of colors and the maximum size of each bottle when prompted.
  3. Follow the on-screen instructions to pour water between bottles.
     
### Sample GamePlay
  start
  green red yellow
  4

  select 3
  deSelect
  selectNext
  selectPrevious
  pour 3
  pour 4
  ReplaceColor yellow blue
  undo
  redo
  addEmptyBottle
  quit

### Contributing
  Feel free to contribute to the project by opening issues or submitting pull requests
