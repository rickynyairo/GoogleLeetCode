fun main(){
    val emails = arrayOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")
    println("Number of unique emails: ${numUniqueEmails(emails)}")
}
private fun numUniqueEmails(emails: Array<String>): Int {
    val forwardTo = hashMapOf<String, Boolean>()
    emails.map{
        val email = filterEmail(it)
        if (!forwardTo.contains(email)){
            forwardTo[email] = true
        }
    }
    return forwardTo.size
}
private fun filterEmail(email: String): String{
    // split email on @
    val emailParts = email.split("@")
    val local = emailParts[0]
    val domain = emailParts[1]
    // if email has a plus, ignore everything after
    val filteredLocal = local.replace(".", "").split("+")[0]
    return "${filteredLocal}@${domain}"
}

