  import { useState, useEffect } from "react"
  import AddUser from "./AddUser"
  import AddEvent from "./AddEvent"
  import { Route, Routes } from 'react-router-dom'

  function App(){
    const [registrations, setRegistrations] = useState([])
    const [users, setUsers] = useState([])
    const [events, setEvents] = useState([])
    const [userId, setUserId] = useState("")
    const [eventId, setEventId] = useState("")

    const fetchRegistrations = () => {
      fetch('http://localhost:8080/registration')
        .then(response => response.json())
        .then(data => setRegistrations(data))
    }

    const addUser = (userName, userMail) => {
      fetch('http://localhost:8080/users', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({name: userName, email: userMail})
      })

    }

    const addEvent = (eventName, eventDesc, eventDate, eventPaymentDeadline, eventPrice, eventLoc) => {
      fetch('http://localhost:8080/events', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({name: eventName, description: eventDesc, date: eventDate, paymentDeadline: eventPaymentDeadline, price: parseFloat(eventPrice), location: eventLoc })
      })
    }

    useEffect(() => {
      fetchRegistrations()
    
      fetch('http://localhost:8080/events')
        .then(response => response.json())
        .then(data => setEvents(data))
    
      fetch('http://localhost:8080/users')
        .then(response => response.json())
        .then(data => setUsers(data))
    }, [])


    const addRegistration = () => {
      console.log("userId:", userId, "eventId:", eventId)
      if(!userId || !eventId) {
        alert("Select both user and event")
        return
      }
      fetch('http://localhost:8080/registration', {
        method: 'POST',
        headers: {'Content-Type': 'application/json' },
        body: JSON.stringify({ userId: parseInt(userId), eventId: parseInt(eventId) })
      })
      .then(response => response.json())
      .then(() => fetchRegistrations())
    }

    return(
      // <div>
      //   <h1>Event Manager</h1>
      //   <AddUser onAddUser={addUser} />
      //   <AddEvent onAddEvent={addEvent} />
      //   <h2>List of registrations</h2>
      //   <select onChange={(e) => {
      //    setUserId(e.target.value)
      //   }}>
      //   <option value="">Select user</option> 
      //       { users.map(user =>(
      //       <option key={user.id} value={user.id}>{user.name}</option>
      //   ))}  
      //   </select>

      //   <select onChange={(e) => {
      //     setEventId(e.target.value)
      //   }}>
      //     <option value="">Select event</option> {
      //       events.map(event => (
      //         <option key = {event.id} value={event.id}>{event.name}</option>
      //       ))
      //     }
      //   </select>


      //   <button onClick={addRegistration}>Add Registration</button>

      //   <h2>List of registrations</h2>
      //   {registrations.map(registration => (
      //     <div key={registration.id}>
      //       <p>{registration.id}: {registration.user.name} → {registration.event.name} — {registration.paymentStatus}</p>
      //     </div>
      //   ))}

      // </div>
      
      <Routes>
        <Route path="/" element={<AddEvent onAddEvent={addEvent}/>} />
        <Route path="/users" element={<AddUser onAddUser={addUser}/>} />
      </Routes>
    )
}

export default App