const regex = /[a-zA-Z]*.gql/gm;
const str = `
#import "queries/fragments/pageConfig.gql"
#import "queries/fragments/seoMetadata.gql"
#import "queries/fragments/video.gql"
#import "queries/fragments/glossary.gql"
#import "queries/fragments/latestNews.gql"
#import "queries/fragments/faqs.gql"
#import "queries/fragments/subscription.gql"
#import "queries/fragments/filterPanel.gql"
#import "queries/fragments/sortBy.gql"
#import "queries/fragments/imageAndLink.gql"

query GetTravelInsuranceFunnelPage($language: String!, $staticTextKeys: [String!], $promotionalBanners: [String]) {
  pageConfig(language: $language) {
    ...PageConfig
  }
  seoMetadata(language: $language, vertical: TI, list: "FUNNEL") {
    ...SeoMetadata
  }

  providerImages: rawJson(
    language: $language
    title:[
      "ti_funnel_allianz_travel",
      "ti_funnel_chubb",
      "ti_funnel_axa",
      "ti_funnel_allied_world",
      "ti_funnel_aig",
      "ti_funnel_fwd",
      "ti_funnel_msig",
      "ti_funnel_starr_companies"
      ]
    contentType: sys_assets) {
    rawJson
    title
  }

  promotionalBanners: imageAndLink(language:$language title:$promotionalBanners) {
    ...ImageAndLink
  }
  resultsPage: generalResultsPage(language: $language, vertical: TI, page: FUNNEL) {
    verticalName: name
    numberMoreResults
    numberInitialResults
    latestNews {
      ...LatestNews
    }
    video {
      ...Video
    }
    glossary {
      ...Glossary
    }
    subscription {
      ...Subscription
    }
    faqs {
      ...Faqs
    }
    staticPageText {
      staticText: text(keys: $staticTextKeys) {
        key
        display(context: COMMON)
        __typename
      }
    }
  }
}
`;


async function search(regex, content){
    
    return new Promise(function(resolve, reject){
        const matches = [];
        let m;
        while ((m = regex.exec(str)) !== null) {
            // This is necessary to avoid infinite loops with zero-width matches
            if (m.index === regex.lastIndex) {
                regex.lastIndex++;
            }
        
            // The result can be accessed through the `m`-variable.
            m.forEach((match, groupIndex) => {
                //console.log(`Found match, group ${groupIndex}: ${match}`);
                matches.push(match)
            });
        }
        resolve(matches)
    });
}

async function main(){
    let matches = await search(regex, str);
    matches.forEach(function(obj){
        console.log(obj);
    })
}

//main();

module.exports = search;