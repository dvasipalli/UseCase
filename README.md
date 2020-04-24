# UseCase

<b>Contains the implementations for following Micro services using spring boot with the respective end points<b>

<ol>
  <li>Login Service
    <ul>
      <li> '/bank/user/authentication' - POST
        <p> Accepts userID, password parameters in request body as JSON object </p>
      </li>
    </ul>
  </li>
    
  <li>Logoff Service
    <ul>
      <li> '/bank/user/authentication' - DELETE
        <p> Accepts sessionID in request body as JSON object </p>
       </li>
     </ul>
  </li>
  
  <li>Account info Service
    
    <ul>
      <li> '/bank/user/dashboard/accountInfo' - POST
        <p>Accepts userID and sessionID in request body as JSON object</p>
      </li>
        
      <li> '/bank/user/dashboard/transactions' - POST
        <p>Accepts sessionID and accountNumber in request body as JSON object</p>
      </li>
      
      <li> '/bank/user/rewards/{userID}' - GET
        <p>Accepts userID as pathvariable and sessionID in the request header</p>
      </li>
    </ul>
    
  </li>
  
  <li>Database Service
    Serves as database layer for the above services exposing multiple endpoints through Eureka.
    Not to be accessed directly.
  </li>
</ol>
