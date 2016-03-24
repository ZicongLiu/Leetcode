/** 
 * Definition for binary tree 
 * struct TreeNode { 
 *     int val; 
 *     TreeNode *left; 
 *     TreeNode *right; 
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {} 
 * }; 
 */  
class Solution {  
public:  
    bool isSymmetric(TreeNode *root) {  
        // Start typing your C/C++ solution below  
        // DO NOT write int main() function  
        if(root==NULL)return true;  
        queue<TreeNode*> lt,rt;  
        if(root->left) lt.push(root->left);  
        if(root->right) rt.push(root->right);  
        TreeNode* l;  
        TreeNode* r;  
        while(!lt.empty() && !rt.empty())  
        {  
            l = lt.front();lt.pop();  
            r = rt.front();rt.pop();  
            if(l == NULL && r == NULL) continue;  
            if(l == NULL || r == NULL) return false;  
            if(l->val != r->val) return false;  
            lt.push(l->left);  
            lt.push(l->right);  
            rt.push(r->right);  
            rt.push(r->left);  
        }  
        if(lt.empty() && rt.empty())  
            return true;  
        else  
            return false;  
    }  
};  