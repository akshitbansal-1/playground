### Requirements
- Multiple entrances and exits
- Different types of parking spots like Handicap, Luxury, Normal
  - Different Tariffs based on them
- Find the nearest entrance from the entrance
- Calculate the fees based on time and spot
- Shouldn't exceed max size
- Support different vehicles
- Support different payments system

### Entities
- ParkingLot
- ParkingSpot
- Ticket
- Terminal
  - EntranceTerminal
  - ExitTerminal
- ParkingStrategy




- Vehicle
  - p: registrationNumber, model
  - m: get/set
- Gate
  - p: id, location
  - m: getters
- EntranceGate
  - p: List<ParkingSpot>
  - m: get/set, getTicket
- ParkingSpotStrategy
  - p: PriorityBlockingQueue<ParkingSpot>, Set<ParkingSpot>, Set<ParkingSpot>
  - m: getParkingSpot(entranceGate), freeParkingSpot(parkingTicket)
- ParkingSpot
  - p: id, location, type, tariff, reserved, vehicleInfo
  - m: getters, abstract getTariff
- ParkingTicket
  - p: id, vehicleInfo, issueTime, parkingSpotId
  - m: getters
- Location
  - p: floor, place
- ExitGate
  - p: List<ParkingSpot>
  - m: freeParkingSpot, calcTariff, depositPayment
- PaymentStrategy: Cash, Card
  - p: 
- com.akshit.Logger
  - m: logEvent
- ParkingLot
  - p: List<ParkingSpot>, List<EntranceGate>, List<ExitGate>, com.akshit.Logger,
  - m: parkVehicle, exitVehicle
