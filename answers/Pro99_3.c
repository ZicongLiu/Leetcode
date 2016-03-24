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
TreeNode *p,*q;
TreeNode *prev;
    void recoverTree(TreeNode *root)
    {
        p=q=prev=NULL;
        inorder(root);
        swap(p->val,q->val);      
    }
    void inorder(TreeNode *root)
    {
        if(root->left)inorder(root->left);
        if(prev!=NULL&&(prev->val>root->val))
        {
            if(p==NULL)p=prev;
            q=root;
        }
        prev=root;
        if(root->right)inorder(root->right);
    }
};