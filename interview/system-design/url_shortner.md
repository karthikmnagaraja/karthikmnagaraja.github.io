Url Shortner:

Scenario: (Case/Interface)
Necessary: (Contain/Hypothesis)
Application: (Services/Algorithms)
Kilobyte: (Data)
Evolution

Scenario:
7 chars to represent short url
expiration time is set to default or given value
Usecase 1: longUrl->shorturl
Usecase 2: short url->longUrl
Usecase 3a: short url(expired)->errorpage
Usecase 3b: short url(notfound)->errorpage
Usecase 4:Custom url
Usecase 5a:Removal Expired shorturls
Usecase 5b:Automatic Expiration shorturls
Usecase 6. Analytics for a given url 
			How many users/times it was clicked
Usecase 7: UI/API

			




Necessary:



Users/Requests:
		 (40requests per sec) *60*60 *24*365 (if you assume 1 request per sec then total number of writes will be 31,536,000)
				=32M*(Number of requests per sec)
		400 requests out of which 80% is read 20% is write => total will be ~12 billion in an year
		Read:	320 requests/per sec
		Write:  

Data:
