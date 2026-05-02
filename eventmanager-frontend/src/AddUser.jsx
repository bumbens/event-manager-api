import { useState } from "react"

import styles from './AddEvent.module.css'
function AddUser({onAddUser}) {
    const [userName, setUserName] = useState("")
    const [userMail, setUserMail] = useState("")

    const submit = () => {
        if (!userName || !userMail) {
            alert("All fields are required")
            return
        }
        onAddUser(userName, userMail)
    }

    return(
        <div className={styles.field}>
            <h2>Add new user</h2>
            <label>User name</label>
            <input type="text" id="name" onChange={(e) => {
                setUserName(e.target.value)
            }}></input>
            <label>User mail</label>
            <input type="email" id="mail" onChange={(e) => {
                setUserMail(e.target.value)
            }}></input>
            <button className={styles.submitButton} onClick={submit}>Submit</button>
        </div>
    )
}

export default AddUser