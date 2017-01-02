*** this is my first experiment for transpoting file with Socket ***
\ based on early attempt(intenet chat project), I think if we can use stream(BufferedReader && PrintStream) to transport informations(UTF-8),  why can not we use it to delieve files( not derictory ). In a way, we can turn file into streams form Client, then turn it back to file at Server. 
\ First, using BufferedInputStream && BufferedOutputStream. Later, I think it's ungood(stupaid). now that, Socekt has its own InputStream && OutputStream, why not use them directly.
\ Later on, it's a litte complecated to delieve the size of data <code>dataSize</code>(because, its needed to initial a byte array). So there is a trick, I define the size of byte array in Server derectly using the <code>dataSize</code> in Client.
\ Probelems, because of raw cersion, some data is loste, I dont know why, and welcome for suggestions
\ Test tips: because of my trick, 
___ please use the picture provided in ./res ___
			 
\ It can work, but its a very very raw version. It will be upgraded in Jan 10 (I hope).