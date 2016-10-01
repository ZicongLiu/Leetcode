class Solution {
public:
  typedef unordered_map<string, unordered_map<string, double>> Map;
  Map m;

  vector<double> calcEquation(vector<pair<string, string>> equations,
   vector<double>& values, vector<pair<string, string>> queries) {
    int n = equations.size();
    for (int i = 0; i < n; ++i) {
      m[equations[i].first][equations[i].second] = values[i];
      m[equations[i].second][equations[i].first] = 1.0 / values[i];
    }
    for (auto& kv: m)
      kv.second[kv.first] = 1.0;
    
    for (auto k = m.begin(); k != m.end(); ++k)
      for (auto i = m.begin(); i != m.end(); ++i)
        for (auto j = m.begin(); j != m.end(); ++j)
          i->second[j->first] = max(i->second[j->first],
                         i->second[k->first] * k->second[j->first]);
    vector<double> res;
    for (const auto& q: queries) {
      auto val = m[q.first][q.second];
      res.push_back(val ? val: -1.0);
    }
    return res;
  }
};