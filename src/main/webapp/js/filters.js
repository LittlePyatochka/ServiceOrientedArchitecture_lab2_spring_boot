Vue.component(
    'filters',
    {
        template:
            `
                <div>
                    <h4 class="col-xs-1 text-center">Options</h4>
                    
                    <h5>Pagination</h5>
                    <div>
                        <label for="elementsCount">Elements count:</label>
                        <input id="elementsCount" type="text" maxlength="8" v-model="elementsCount">
                        <label for="pageNumber" class="ml-5">Page number</label>
                        <input id="pageNumber" type="text" maxlength="8" v-model="pageNumber">
                    </div>
                    
                    <h5>Order by id</h5>
                    <div>
                        <label for="orderDirectionAsc1" class="ml-5">Asc</label>
                        <input id="orderDirectionAsc1" type="radio" value="a" v-model="orderDirection1">
                        <label for="orderDirectionDesc1" class="pl-3">Desc</label>
                        <input id="orderDirectionDesc1" type="radio" value="d" v-model="orderDirection1">
                        <label for="orderDirectionNone1" class="pl-3">None</label>
                        <input id="orderDirectionNone1" type="radio" value="" v-model="orderDirection1">
                        
                        <label for="orderById1" class="pl-3">Id</label>
                        <input id="orderById1" type="radio" value="id" v-model="orderBy1">
                        
                           <label for="orderByNone1" class="pl-3">None</label>
                        <input id="orderByNone1" type="radio" value="" v-model="orderBy1" checked>
                    </div>
                    
                    <h5>Order by Name</h5>
                    <div>
  
                        <label for="orderDirectionAsc2" class="ml-5">Asc</label>
                        <input id="orderDirectionAsc2" type="radio" value="a" v-model="orderDirection2">
                        <label for="orderDirectionDesc2" class="pl-3">Desc</label>
                        <input id="orderDirectionDesc2" type="radio" value="d" v-model="orderDirection2">
                        <label for="orderDirectionNone2" class="pl-3">None</label>
                        <input id="orderDirectionNone2" type="radio" value="" v-model="orderDirection2">
                        
                         <label for="orderByName2" class="pl-3">Name</label>
                        <input id="orderByName2" type="radio" value="name" v-model="orderBy2">
                        <label for="orderByNone2" class="pl-3">None</label>
                        <input id="orderByNone2" type="radio" value="" v-model="orderBy2" checked>
                    </div>
                    
                    <h5>Order by Coordinates</h5>
                    <div>

                        <label for="orderDirectionAsc3" class="ml-5">Asc</label>
                        <input id="orderDirectionAsc3" type="radio" value="a" v-model="orderDirection3">
                        <label for="orderDirectionDesc3" class="pl-3">Desc</label>
                        <input id="orderDirectionDesc3" type="radio" value="d" v-model="orderDirection3">
                        <label for="orderDirectionNone3" class="pl-3">None</label>
                        <input id="orderDirectionNone3" type="radio" value="" v-model="orderDirection3">
                        
                         <label for="orderByCoordinates3" class="pl-3">Coorinates id</label>
                        <input id="orderByCoordinates3" type="radio" value="coordinates" v-model="orderBy3">
                        <label for="orderByNone3" class="pl-3">None</label>
                        <input id="orderByNone3" type="radio" value="" v-model="orderBy3" checked>
                    </div>
                    
                    <h5>Order by CreationDate</h5>
                    <div>

                        <label for="orderDirectionAsc4" class="ml-5">Asc</label>
                        <input id="orderDirectionAsc4" type="radio" value="a" v-model="orderDirection4">
                        <label for="orderDirectionDesc4" class="pl-3">Desc</label>
                        <input id="orderDirectionDesc4" type="radio" value="d" v-model="orderDirection4">
                        <label for="orderDirectionNone4" class="pl-3">None</label>
                        <input id="orderDirectionNone4" type="radio" value="" v-model="orderDirection4">
                        
                         <label for="orderByCreationDate4" class="pl-3">Creation date</label>
                        <input id="orderByCreationDate4" type="radio" value="creationDate" v-model="orderBy4">
                         <label for="orderByNone4" class="pl-3">None</label>
                        <input id="orderByNone4" type="radio" value="" v-model="orderBy4" checked>
                    </div>
                    
                    <h5>Order by Health</h5>
                    <div>
                        <label for="orderDirectionAsc5" class="ml-5">Asc</label>
                        <input id="orderDirectionAsc5" type="radio" value="a" v-model="orderDirection5">
                        <label for="orderDirectionDesc5" class="pl-3">Desc</label>
                        <input id="orderDirectionDesc5" type="radio" value="d" v-model="orderDirection5">
                        <label for="orderDirectionNone5" class="pl-3">None</label>
                        <input id="orderDirectionNone5" type="radio" value="" v-model="orderDirection5">
                        
                        <label for="orderByHealth5" class="pl-3">Health</label>
                        <input id="orderByHealth5" type="radio" value="health" v-model="orderBy5">
                        <label for="orderByNone5" class="pl-3">None</label>
                        <input id="orderByNone5" type="radio" value="" v-model="orderBy5" checked>
                    </div>
                    
                    <h5>Order by HeartCount</h5>
                    <div>
                        <label for="orderDirectionAsc6" class="ml-5">Asc</label>
                        <input id="orderDirectionAsc6" type="radio" value="a" v-model="orderDirection6">
                        <label for="orderDirectionDesc6" class="pl-3">Desc</label>
                        <input id="orderDirectionDesc6" type="radio" value="d" v-model="orderDirection6">
                        <label for="orderDirectionNone6" class="pl-3">None</label>
                        <input id="orderDirectionNone6" type="radio" value="" v-model="orderDirection6">
                        
                        <label for="orderByHeartCount6" class="pl-3">Heart count</label>
                        <input id="orderByHeartCount6" type="radio" value="heartCount" v-model="orderBy6">
                        <label for="orderByNone6" class="pl-3">None</label>
                        <input id="orderByNone6" type="radio" value="" v-model="orderBy6" checked>
                    </div>
                    
                    <h5>Order by Loyal</h5>
                    <div>
                        <label for="orderDirectionAsc7" class="ml-5">Asc</label>
                        <input id="orderDirectionAsc7" type="radio" value="a" v-model="orderDirection7">
                        <label for="orderDirectionDesc7" class="pl-3">Desc</label>
                        <input id="orderDirectionDesc7" type="radio" value="d" v-model="orderDirection7">
                        <label for="orderDirectionNone7" class="pl-3">None</label>
                        <input id="orderDirectionNone7" type="radio" value="" v-model="orderDirection7">
                        
                        <label for="orderByLoyal7" class="pl-3">Loyal</label>
                        <input id="orderByLoyal7" type="radio" value="loyal" v-model="orderBy7">
                             <label for="orderByNone7" class="pl-3">None</label>
                        <input id="orderByNone7" type="radio" value="" v-model="orderBy7" checked>
                    </div>
                    
                    <h5>Order by Category</h5>
                    <div>
                        <label for="orderDirectionAsc8" class="ml-5">Asc</label>
                        <input id="orderDirectionAsc8" type="radio" value="a" v-model="orderDirection8">
                        <label for="orderDirectionDesc8" class="pl-3">Desc</label>
                        <input id="orderDirectionDesc8" type="radio" value="d" v-model="orderDirection8">
                        <label for="orderDirectionNone8" class="pl-3">None</label>
                        <input id="orderDirectionNone8" type="radio" value="" v-model="orderDirection8">
                        
                        <label for="orderByCategory8" class="pl-3">Category</label>
                        <input id="orderByCategory8" type="radio" value="category" v-model="orderBy8">
                        <label for="orderByNone8" class="pl-3">None</label>
                        <input id="orderByNone8" type="radio" value="" v-model="orderBy8" checked>
                    </div>
                    
                    <h5>Order by Chapter</h5>
                    <div>
                        <label for="orderDirectionAsc9" class="ml-5">Asc</label>
                        <input id="orderDirectionAsc9" type="radio" value="a" v-model="orderDirection9">
                        <label for="orderDirectionDesc9" class="pl-3">Desc</label>
                        <input id="orderDirectionDesc9" type="radio" value="d" v-model="orderDirection9">
                        <label for="orderDirectionNone9" class="pl-3">None</label>
                        <input id="orderDirectionNone9" type="radio" value="" v-model="orderDirection9">
                        
                        <label for="orderByChapter9" class="pl-3">Chapter</label>
                        <input id="orderByChapter9" type="radio" value="chapter" v-model="orderBy9">
                         <label for="orderByNone9" class="pl-3">None</label>
                        <input id="orderByNone9" type="radio" value="" v-model="orderBy9" checked>
                    </div>
                    
                    <h5>Filter</h5>
                    <div>
                        <label for="filterById">Id</label>
                        <input id="filterById" type="text" maxlength="8" v-model="filterById">
                    </div>
                    <div>
                        <label for="filterByName">Name</label>
                        <input id="filterByName" type="text" maxlength="256" v-model="filterByName">
                    </div>
                    <div>
                        <label for="filterByCoordinates">Coordinates</label>
                        <input id="filterByCoordinates" type="text" maxlength="8" v-model="filterByCoordinates">
                    </div>
                    <div>
                        <label for="filterByCreationDate">Creation date</label>
                        <input id="filterByCreationDate" type="text" maxlength="10" v-model="filterByCreationDate">
                        
<!--                        <label for="filterByCreationDateActionLess" class="pl-5"><</label>-->
<!--                        <input id="filterByCreationDateActionLess" type="radio" value="<" v-model="filterByCreationDateAction" name="filterByCreationDateAction">-->
<!--                        <label for="filterByCreationDateActionEqual" class="pl-5">==</label>-->
<!--                        <input id="filterByCreationDateActionEqual" type="radio" value="==" v-model="filterByCreationDateAction" name="filterByCreationDateAction">-->
<!--                        <label for="filterByCreationDateActionGreater" class="pl-5">\></label>-->
<!--                        <input id="filterByCreationDateActionGreater" type="radio" value=">" v-model="filterByCreationDateAction" name="filterByCreationDateAction">-->
<!--                        <label for="filterByCreationDateActionLessEqual" class="pl-5"><=</label>-->
<!--                        <input id="filterByCreationDateActionLessEqual" type="radio" value="<=" v-model="filterByCreationDateAction" name="filterByCreationDateAction">     -->
<!--                        <label for="filterByCreationDateActionGreaterEqual" class="pl-5">>=</label>-->
<!--                        <input id="filterByCreationDateActionGreaterEqual" type="radio" value=">=" v-model="filterByCreationDateAction" name="filterByCreationDateAction">-->
                    </div>
                    <div>
                        <label for="filterByHealth">Health</label>
                        <input id="filterByHealth" type="text" maxlength="8" v-model="filterByHealth">
                        
<!--                        <label for="filterByHealthLess" class="pl-5"><</label>-->
<!--                        <input id="filterByHealthLess" type="radio" value="<" v-model="filterByHealth" name="filterByHealth">-->
<!--                        <label for="filterByHealthEqual" class="pl-5">==</label>-->
<!--                        <input id="filterByHealthEqual" type="radio" value="==" v-model="filterByHealth" name="filterByHealth">-->
<!--                        <label for="filterByHealthGreater" class="pl-5">\></label>-->
<!--                        <input id="filterByHealthGreater" type="radio" value=">" v-model="filterByHealth" name="filterByHealth">-->
<!--                        <label for="filterByHealthLessEqual" class="pl-5"><=</label>-->
<!--                        <input id="filterByHealthLessEqual" type="radio" value="<=" v-model="filterByHealth" name="filterByHealth">     -->
<!--                        <label for="filterByHealthGreaterEqual" class="pl-5">>=</label>-->
<!--                        <input id="filterByHealthGreaterEqual" type="radio" value=">=" v-model="filterByHealth" name="filterByHealth">-->
                    </div>
                    <div>
                        <label for="filterByHeartCount">Heart count</label>
                        <input id="filterByHeartCount" type="text" maxlength="8" v-model="filterByHeartCount">
                        
<!--                        <label for="filterByHeartCountActionLess" class="pl-5"><</label>-->
<!--                        <input id="filterByHeartCountActionLess" type="radio" value="<" v-model="filterByHeartCountAction" name="filterByHeartCountAction">-->
<!--                        <label for="filterByHeartCountActionEqual" class="pl-5">==</label>-->
<!--                        <input id="filterByHeartCountActionEqual" type="radio" value="==" v-model="filterByHeartCountAction" name="filterByHeartCountAction">-->
<!--                        <label for="filterByHeartCountActionGreater" class="pl-5">\></label>-->
<!--                        <input id="filterByHeartCountActionGreater" type="radio" value=">" v-model="filterByHeartCountAction" name="filterByHeartCountAction">-->
<!--                        <label for="filterByHeartCountActionLessEqual" class="pl-5"><=</label>-->
<!--                        <input id="filterByHeartCountActionLessEqual" type="radio" value="<=" v-model="filterByHeartCountAction" name="filterByHeartCountAction">     -->
<!--                        <label for="filterByHeartCountActionGreaterEqual" class="pl-5">>=</label>-->
<!--                        <input id="filterByHeartCountActionGreaterEqual" type="radio" value=">=" v-model="filterByHeartCountAction" name="filterByHeartCountAction">-->
                    </div>
                    <div>
                        <label for="filterByLoyal">Loyal</label>
<!--                        <input id="filterByLoyal" type="text" maxlength="12" v-model="filterByLoyal">-->
                        <label for="filterByLoyal" class="pl-5">true</label>
                        <input id="filterByLoyal" type="radio" value="true" v-model="filterByLoyal" name="filterByLoyal">
                        <label for="filterByLoyal" class="pl-5">false</label>
                        <input id="filterByLoyal" type="radio" value="false" v-model="filterByLoyal" name="filterByLoyal">
                        
<!--                        <label for="filterByLoyalActionLess" class="pl-5"><</label>-->
<!--                        <input id="filterByLoyalActionLess" type="radio" value="<" v-model="filterByLoyalAction" name="filterByLoyalAction">-->
<!--                        <label for="filterByLoyalActionEqual" class="pl-5">==</label>-->
<!--                        <input id="filterByLoyalActionEqual" type="radio" value="==" v-model="filterByLoyalAction" name="filterByLoyalAction">-->
<!--                        <label for="filterByLoyalActionGreater" class="pl-5">\></label>-->
<!--                        <input id="filterByLoyalActionGreater" type="radio" value=">" v-model="filterByLoyalAction" name="filterByLoyalAction">-->
<!--                        <label for="filterByLoyalActionLessEqual" class="pl-5"><=</label>-->
<!--                        <input id="filterByLoyalActionLessEqual" type="radio" value="<=" v-model="filterByLoyalAction" name="filterByLoyalAction">     -->
<!--                        <label for="filterByLoyalActionGreaterEqual" class="pl-5">>=</label>-->
<!--                        <input id="filterByLoyalActionGreaterEqual" type="radio" value=">=" v-model="filterByLoyalAction" name="filterByLoyalAction">-->
                    </div>
                    <div>
                        <label for="filterByCategory">Category</label>
                        
                        <label for="filterByCategoryAGGRESSOR" class="pl-5">AGGRESSOR</label>
                        <input id="filterByCategoryAGGRESSOR" type="radio" value="AGGRESSOR" v-model="filterByCategory" name="filterByCategory">
                        <label for="filterByCategoryLIBRARIAN" class="pl-5">LIBRARIAN</label>
                        <input id="filterByCategoryLIBRARIAN" type="radio" value="LIBRARIAN" v-model="filterByCategory" name="filterByCategory">
                        <label for="filterByCategoryHELIX" class="pl-5">HELIX</label>
                        <input id="filterByCategoryHELIX" type="radio" value="HELIX" v-model="filterByCategory" name="filterByCategory">
                        <label for="filterByCategoryAPOTHECARY" class="pl-5">APOTHECARY</label>
                        <input id="filterByCategoryAPOTHECARY" type="radio" value="APOTHECARY" v-model="filterByCategory" name="filterByCategory">
                    </div>
                    <div>
                        <label for="filterByChapter">Chapter</label>
                        <input id="filterByChapter" type="text" maxlength="8" v-model="filterByChapter">
                    </div>
                    
                    <button class="btn btn-success" v-on:click="filter()" type="submit">Filter</button>
                    <button class="btn btn-warning" v-on:click="clear()" type="button">Clear</button>
                </div>
            `,

        data: function () {
            return {
                elementsCount: '',
                pageNumber: '',
                orderBy1: '',
                orderDirection1: '',
                orderBy2: '',
                orderDirection2: '',
                orderBy3: '',
                orderDirection3: '',
                orderBy4: '',
                orderDirection4: '',
                orderBy5: '',
                orderDirection5: '',
                orderBy6: '',
                orderDirection6: '',
                orderBy7: '',
                orderDirection7: '',
                orderBy8: '',
                orderDirection8: '',
                orderBy9: '',
                orderDirection9: '',
                filterById: '',
                filterByName: '',
                filterByCoordinates: '',
                filterByCreationDate: '',
                // filterByCreationDateAction: '',
                filterByHealth: '',
                // filterByHealthAction: '',
                filterByHeartCount: '',
                // filterByHeartCountAction: '',
                filterByLoyal: '',
                // filterByLoyalAction: '',
                filterByCategory: '',
                filterByChapter: ''
            }
        },
        methods: {
            filter: function () {
                this.$emit('filter', {
                    'elementsCount': this.elementsCount,
                    'pageNumber': this.pageNumber,
                    'orderBy1': this.orderBy1,
                    'orderDirection1': this.orderDirection1,
                    'orderBy2': this.orderBy2,
                    'orderDirection2': this.orderDirection2,
                    'orderBy3': this.orderBy3,
                    'orderDirection3': this.orderDirection3,
                    'orderBy4': this.orderBy4,
                    'orderDirection4': this.orderDirection4,
                    'orderBy5': this.orderBy5,
                    'orderDirection5': this.orderDirection5,
                    'orderBy6': this.orderBy6,
                    'orderDirection6': this.orderDirection6,
                    'orderBy7': this.orderBy7,
                    'orderDirection7': this.orderDirection7,
                    'orderBy8': this.orderBy8,
                    'orderDirection8': this.orderDirection8,
                    'orderBy9': this.orderBy9,
                    'orderDirection9': this.orderDirection9,
                    'filterById': this.filterById,
                    'filterByName': this.filterByName,
                    'filterByCoordinates': this.filterByCoordinates,
                    'filterByCreationDate': this.filterByCreationDate,
                    // 'filterByCreationDateAction': this.filterByCreationDateAction,
                    'filterByHealth': this.filterByHealth,
                    // 'filterByHealthAction': this.filterByHealthAction,
                    'filterByHeartCount': this.filterByHeartCount,
                    // 'filterByHeartCountAction': this.filterByHeartCountAction,
                    'filterByLoyal': this.filterByLoyal,
                    // 'filterByLoyalAction': this.filterByLoyalAction,
                    'filterByCategory': this.filterByCategory,
                    'filterByChapter': this.filterByChapter
                });
            },
            clear(){
                this.elementsCount = '';
                this.pageNumber = '';
                this.orderBy1 = '';
                this.orderDirection1 = '';
                this.orderBy2 = '';
                this.orderDirection2 = '';
                this.orderBy3 = '';
                this.orderDirection3 = '';
                this.orderBy4 = '';
                this.orderDirection4 = '';
                this.orderBy5 = '';
                this.orderDirection5 = '';
                this.orderBy6 = '';
                this.orderDirection6 = '';
                this.orderBy7 = '';
                this.orderDirection7 = '';
                this.orderBy8 = '';
                this.orderDirection8 = '';
                this.orderBy9 = '';
                this.orderDirection9 = '';
                this.filterById = '';
                this.filterByName = '';
                this.filterByCoordinates = '';
                this.filterByCreationDate = '';
                this.filterByHealth = '';
                this.filterByHeartCount = '';
                this.filterByLoyal = '';
                this.filterByCategory = '';
                this.filterByChapter = '';
            }
        }
    }
);