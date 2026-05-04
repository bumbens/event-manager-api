import { useEffect, useState } from "react";
import styles from './css/AddEvent.module.css'


function AddEvent({onAddEvent}) {
    const [eventName, setEventName] = useState("")
    const [eventDesc, setEventDesc] = useState("")
    const [eventDate, setEventDate] = useState("")
    const [eventPaymentDeadline, setEventPaymentDeadline] = useState("")
    const [eventPrice, setEventPrice] = useState("")
    const [eventLoc, setEventLoc] = useState("")

    const submit = () => {
        if (!eventName || !eventDesc || !eventDate || !eventPaymentDeadline || !eventPrice || !eventLoc) {
            alert("All fields are required")
            return
        }
        onAddEvent(eventName, eventDesc, eventDate, eventPaymentDeadline, eventPrice, eventLoc)
    }

    useEffect(() => {
        document.title = 'Add Event | Event Manager'
    }, [])

    return(
        <div className={styles.field}>
            <h2>Add new event</h2>
            <label>Event name</label>
            <input type = "text" id="name" onChange={(e) => {
                setEventName(e.target.value)
            }}></input>
            <label>Event description</label>
            <input type = "text" id="desc" onChange={(e) => {
                setEventDesc(e.target.value)
            }}></input>
            <label>Event date</label>
            <input type = "date" id="date" onChange={(e) => {
                setEventDate(e.target.value)
            }}></input>
            <label>Payment deadline</label>
            <input type = "date" id="paymentDeadline" onChange={(e) => {
                setEventPaymentDeadline(e.target.value)
            }}></input>
            <label>Ticket price</label>
            <input type = "number" id="price" onChange={(e) => {
                setEventPrice(e.target.value)
            }}></input>
            <label>Event Location</label>
            <input type = "text" id="loc" onChange={(e) => {
                setEventLoc(e.target.value)
            }}></input>
            <button className={styles.submitButton} onClick={submit}>Submit</button>
        </div>
    )
}

export default AddEvent