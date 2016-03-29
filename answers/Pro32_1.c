int findlength(string s) {  
    int paired = 0;
    int len = 0;  
    stack<char> stk;  
    for(int i=0; i< s.length(); ++i)  
    {  
        if(s[i]=='(')stk.push(')');  
        else if(!stk.empty()){  
            stk.pop();  
            len+=2;  
            if(stk.empty()&&paired<len)  
                paired=len;  
        }else{  
            len = 0;  
        }  
    }  
    if(stk.empty() && paired == 0)  
        paired += len;  
    return paired;  
}  
int longestValidParentheses(string s) {  
    // Note: The Solution object is instantiated only once.  
    int max = 0;  
    int tmp = 0;  
    for(int i=0; i< s.length();i++)  
    {  
        tmp = findlength(s.substr(i));  
        max = max>tmp?max:tmp;  
    }  
    return max;  
} 