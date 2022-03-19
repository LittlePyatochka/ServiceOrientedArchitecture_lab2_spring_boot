Vue.component(
    'add-marine',
    {
        template:
            `
            <div>
                <h4 class="col-xs-1 text-center">Add/update Space marine</h4>
                <div>
                    <label for="id">Id</label>
                    <input id="id" type="text" maxlength="8" v-model="id">
                </div>
                <div>
                    <label for="name">Name</label>
                    <input id="name" type="text" maxlength="256" v-model="name">
                </div>
                <div>
                    <label for="coordinates">Coordinates</label>
                    <input id="coordinates" type="text" maxlength="8" v-model="coordinates">
                </div>
<!--                <div>-->
<!--                    <label for="creationDate">Creation date</label>-->
<!--                    <span id="creationDate">-->
<!--                    <label for="creationDate" v-model="creationDate"></label>-->
<!--                    {{ formatCreationDate(creationDate) }}-->
<!--                    </span>-->
<!--                </div>-->
                <div>
                    <label for="health">Health</label>
                    <input id="health" type="text" maxlength="8" v-model="health">
                </div>
                <div>
                    <label for="heartCount">Heart count</label>
                    <input id="heartCount" type="text" maxlength="8" v-model="heartCount">
                </div>
                <div>
                    <label for="loyal">Loyal</label>
                    <label for="loyal" class="pl-5">true</label>
                    <input id="loyal" type="radio" value="true" v-model="loyal" name="loyal">
                    <label for="loyal" class="pl-5">false</label>
                    <input id="loyal" type="radio" value="false" v-model="loyal" name="loyal">
                </div>
                <div>
                    <label for="category">Category</label>
                    
                    <label for="filterByCategoryAGGRESSOR" class="pl-5">AGGRESSOR</label>
                    <input id="filterByCategoryAGGRESSOR" type="radio" value="AGGRESSOR" v-model="category" name="category">
                    <label for="filterByCategoryLIBRARIAN" class="pl-5">LIBRARIAN</label>
                    <input id="filterByCategoryLIBRARIAN" type="radio" value="LIBRARIAN" v-model="category" name="category">
                    <label for="filterByCategoryHELIX" class="pl-5">HELIX</label>
                    <input id="filterByCategoryHELIX" type="radio" value="HELIX" v-model="category" name="category">
                    <label for="filterByCategoryAPOTHECARY" class="pl-5">APOTHECARY</label>
                    <input id="filterByCategoryAPOTHECARY" type="radio" value="APOTHECARY" v-model="category" name="category">
                </div>
                <div>
                    <label for="chapter">Chapter</label>
                    <input id="chapter" type="text" maxlength="8" v-model="chapter">
                </div>
                
                <button v-if="id" class="btn btn-success" v-on:click="addSpaceMarine()" type="submit">Update</button>
                <button v-else class="btn btn-success" v-on:click="addSpaceMarine()" type="submit">Add</button>
                <button class="btn btn-warning" v-on:click="clear()" type="button">Clear</button>

            </div>
            `,

        props: ["chapterlist", "coordinateslist"],
        data: function () {
            return {
                id: '',
                name: '',
                coordinates: '',
                health: '',
                heartCount: '',
                loyal: '',
                category: '',
                creationDate: '',
                chapter: ''
            }
        },
        methods: {
            addSpaceMarine: function () {
                let spaceMarine = {
                    'name': this.name,
                    'creationDate': this.creationDate,
                    'coordinates': this.coordinates,
                    'health': this.health,
                    'heartCount': this.heartCount,
                    'loyal': this.loyal
                }
                if (this.category) {
                    spaceMarine.category = this.category
                }
                if (this.chapter) {
                    spaceMarine.chapter = this.chapter
                }
                if (this.id) {
                    spaceMarine.id = this.id
                }

                this.$emit('addspacemarine', spaceMarine);
            },
            updateFields: function (spaceMarine) {
                this.id = spaceMarine.id
                this.name = spaceMarine.name
                this.coordinates = spaceMarine.coordinates.id
                this.creationDate = spaceMarine.creationDate
                this.health = spaceMarine.health
                this.heartCount = spaceMarine.heartCount
                this.loyal = spaceMarine.loyal
                this.category = spaceMarine.category
                this.chapter = spaceMarine.chapter.id
            },
            formatCreationDate: function (creationDate) {
                return new Date(creationDate).toLocaleDateString();
            },
            clear(){
                this.id = '',
                this.name = '',
                this.coordinates = '',
                this.creationDate = '',
                this.health = '',
                this.heartCount = '',
                this.loyal = '',
                this.category = '',
                this.chapter = ''
            }
        }
    }
);