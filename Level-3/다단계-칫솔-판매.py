def solution(enroll, referral, seller, amount):
    graph,ans = {},{e:0 for e in enroll}

    for e,r in zip(enroll,referral): graph[e]=r

    for s,a in zip(seller,amount):
        money = a*100
        rate = money//10
        ans[s] += money-rate
        x = graph[s]

        while x != "-":
            if rate==0: break
            ans[x] += rate-rate//10
            rate//=10
            x = graph[x]

    return list(ans.values())
