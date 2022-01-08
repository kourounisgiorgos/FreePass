**HOW TO RUN**
Χρειαζεται να εχετε εγκατεστημενη την MySQL και να εχετε ενα ενεργο schema. Για να αναγνωριζει η εφαρμογη το schema σας
πηγαινετε στο application.properties αρχειο και αλλαζετε τις μεταβλητες αναλογα με τα στοιχεια της βασης σας.
Επειτε απλα πατα run και η εφαρμογη τρεχει στo port 8080.




path="/saveApplication" , Method=POST , authentication=CITIZEN_ROLE
Headers: Content-Type", "application/json"
Body: {
          "userName": full_name,
          "ssn":ssn,
          "unemployedSince" : unemployed
       }

Description:
Ο πολιτης καλει το API για να εκτελεσει την αιτηση του.
Επιτρεπεται μονο μια αιτηση ανα χρηστη και το API δεν επιτρεπει duplicates.
Για status_code = 400 σημαινει οτι εντοπιστηκε duplicate.

--------------------------------------------------------------------------------------------

path="/saveCitizen", Method=POST, authentication=ALL
Headers: Content-Type", "application/json"
Body:{
         "userName": first_name + " " + last_name,
         "ssn":ssn,
         "email": email,
         "status":"waiting",
         "phoneNumber": phone,
         "unemployedSince" : date
      }

Description:
Χρησιμοποιειται απο τους πολιτες για να αποθηκεύσει τα στοιχεια του στην βαση μας.
Αυτο το api καλειται σε συνδυασμο με το /saveUser 
και δεν θα επρεπε να καλεστει αν το response του saveUser ειναι status code 400.

--------------------------------------------------------------------------------------------

path="/updateCitizen/{user_name}" , Method=PUT , authentication=OAED_ROLE
Headers: Content-Type", "application/json"
Βοdy:"waiting"/"accepted"/"rejected"

Description:
Καλειται απο τον υπαλληλο ΟΑΕΔ για να επικυρωσει την αποφαση για την αιτηση ενος πολιτη.
Δεχεται ως παραμετρο το username του πολιτη που θελουμε να τροποποιησουμε,
αναγκαστικα πρεπει να δεχεται μια απο τις τιμες waiting/accepted/rejected

--------------------------------------------------------------------------------------------

path="/saveUser" , Method=POST authentication=ALL
Headers: Content-Type", "application/json"
Body:{
        "userName": user_name,
        "password": password,
        "roles": role,
     }

Description:
Μπορει να χρησιμοποιηθει απο τον πολιτη για την δημιουργια λογαριασμου πολιτη και επισης μπορει
ο μοναδικος admin του συστηματος να προσθεσει oaed/oasa λογαριασμο στο συστημα
Επιτρεπεται μονο ενας χρηστης ανα ονομα και το API δεν επιτρεπει duplicates.
Για status_code = 400 σημαινει οτι εντοπιστηκε duplicate.

