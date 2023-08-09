# Requirements
- Elevator should have a max capacity
- Elevator should choose the next floor efficiently
  - Can use strategy pattern
- Elevator should have stop button
- Elevator should have resume button
- Elevator should have a reset button

# Entities
- Floor
  - p: floorId, RequestElevatorButton
  - m: getFloorId, pressButton
- ElevatorButton
  - p: buttonId, name
  - m: abstract onPress
  - StopButton
    - m: onPress
  - FloorButton
    - m: onPress
  - ResumeButton
    - m: onPress
  - ResetButton
    - m: onPress
- RequestElevatorButton
  - p: floorId, pressed, direction
  - m: pressButton
- Elevator
  - List<ElevatorButton>, List<Floor>, constructor(readDisk and restart), Queue<Step>
  - m: requestElevator(floorId, direction), pressButton(FloorButton)
  - pr: updateNext